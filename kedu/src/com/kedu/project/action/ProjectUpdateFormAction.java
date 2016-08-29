package com.kedu.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.project.dao.ProjectDao;
import com.kedu.project.dto.ProjectDto;

public class ProjectUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/project/projectUpdate.jsp";
		int pjtid = Integer.parseInt(request.getParameter("pjtid"));
		System.out.println(pjtid);
		ProjectDao pDao = ProjectDao.getInstance();
		
		ProjectDto pDto = pDao.selectOneProject(pjtid);
		
		request.setAttribute("project", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
