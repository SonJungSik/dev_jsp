package com.kedu.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.project.dao.ProjectDao;
import com.kedu.project.dto.ProjectDto;

public class ProjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/project/projectList.jsp";
		
		ProjectDao pDao = ProjectDao.getInstance();
		
		List<ProjectDto> projectList = pDao.selectAllProject();
		System.out.println(projectList);
		request.setAttribute("projectList", projectList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
