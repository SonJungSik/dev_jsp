package com.kedu.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.project.dao.ProjectDao;
import com.kedu.project.dto.ProjectDto;
import com.kedu.skill.dao.SkillDao;
import com.kedu.skill.dto.SkillDto;

public class ProjectWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDto pDto = new ProjectDto();
		SkillDto sDto = new SkillDto();
		
		pDto.setPjtid(request.getParameter("pjtid"));
		pDto.setPjtnm(request.getParameter("pjtnm"));
		pDto.setSite(request.getParameter("site"));
		pDto.setStartdt(request.getParameter("startdt"));
		pDto.setEnddt(request.getParameter("enddt"));
		pDto.setContents(request.getParameter("contents"));
		
		sDto.setSkill(request.getParameterValues("skill"));
		sDto.setPjtid(request.getParameter("pjtid"));
		SkillDao sDao = SkillDao.getInstance();
		ProjectDao pDao = ProjectDao.getInstance();
		
		pDao.insertProject(pDto);
		sDao.insertSkills(sDto);
		new ProjectListAction().execute(request, response);
	}

}
