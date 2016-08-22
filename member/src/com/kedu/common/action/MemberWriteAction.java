package com.kedu.common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

public class MemberWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto mDto = new MemberDto();
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("pwd"));
		mDto.setName(request.getParameter("name"));
		mDto.setEmail(request.getParameter("email"));
		mDto.setPwd(request.getParameter("pwd"));
		
		MemberDao mDao = MemberDao.getInstance();
		mDao.insertMember(mDto);
		
		new MemberListAction().execute(request, response);
		
	}
}
