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
import com.kedu.skill.dao.SkillDao;
import com.kedu.skill.dto.SkillDto;

public class ProjectDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/project/projectDetail.jsp";
		
		String pjtid = request.getParameter("pjtid");
		
		ProjectDao pDao = ProjectDao.getInstance();
		
		ProjectDto pDto = pDao.selectOneProject(pjtid);
		SkillDao sDao = SkillDao.getInstance();
		List<SkillDto> skillList = sDao.selectSkill();
		List<SkillDto> skillCheck = sDao.selectSkillCheck(pjtid);
		
		for (SkillDto skillDto : skillCheck) {
			System.out.println(skillDto.getSkillno());

		}
					
		request.setAttribute("skillCheck", skillCheck);
		request.setAttribute("skillList", skillList);
		request.setAttribute("project", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
