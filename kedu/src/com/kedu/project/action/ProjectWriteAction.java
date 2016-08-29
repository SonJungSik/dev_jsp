package com.kedu.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.project.dao.ProjectDao;
import com.kedu.project.dto.ProjectDto;

public class ProjectWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDto pDto = new ProjectDto();
		
		pDto.setPjtnm(request.getParameter("pjtnm"));
		pDto.setSite(request.getParameter("site"));
		pDto.setStartdt(request.getParameter("startdt"));
		pDto.setEnddt(request.getParameter("enddt"));
		pDto.setContents(request.getParameter("contents"));
		
		ProjectDao pDao = ProjectDao.getInstance();
		pDao.insertProject(pDto);
		
		new ProjectListAction().execute(request, response);
	}

}
