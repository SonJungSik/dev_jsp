package com.kedu.skill.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kedu.common.action.Action;
import com.kedu.skill.dao.SkillDao;
import com.kedu.skill.dto.SkillDto;

public class SkillChkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaa");
		String pjtid = request.getParameter("pjtid");
		SkillDao sDao = SkillDao.getInstance();
		List<SkillDto> skillCheck = sDao.selectSkillCheck(pjtid);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(skillCheck));
		
		
	}

}
