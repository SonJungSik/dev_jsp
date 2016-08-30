package com.kedu.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.common.util.PageDto;
import com.kedu.common.util.PageHelper;
import com.kedu.project.dao.ProjectDao;
import com.kedu.project.dto.ProjectDto;

public class ProjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/project/projectList.jsp";

		int curPage = (request.getParameter("curPage") == null) ? 1 : Integer.parseInt(request.getParameter("curPage"));
		int numPerPage = 10;
		int totalRecord = 0;

		ProjectDao pDao = ProjectDao.getInstance();
		totalRecord = pDao.totalpageProject();

		int start = (curPage - 1) * numPerPage + 1;
		int end = start + numPerPage - 1;

		List<ProjectDto> projectList = pDao.selectCurPageProject(start, end);
		PageDto pageDto = PageHelper.getBlockGroup(curPage, numPerPage, totalRecord);

		request.setAttribute("projectList", projectList);
		request.setAttribute("pageDto", pageDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
