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

public class ProjectWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/project/projectWrite.jsp";
		
		ProjectDao pDao = ProjectDao.getInstance();
		SkillDao sDao = SkillDao.getInstance();
		
		List<SkillDto> skillList = sDao.selectSkill();
		
		System.out.println(skillList);
		ProjectDto pDto = pDao.getPjtid();
		
		request.setAttribute("getPjtid", pDto);
		request.setAttribute("skillList", skillList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
