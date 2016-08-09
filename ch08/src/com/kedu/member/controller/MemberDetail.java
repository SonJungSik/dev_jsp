package com.kedu.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

/**
 * Servlet implementation class MemberDetail
 */
@WebServlet("/MemberDetail")
public class MemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String userid = request.getParameter("userid");

		MemberDao memberDao = new MemberDao();

		MemberDto memberDto = memberDao.selectOneByIdMember(userid);
		// 처리결과 Request 저장
		request.setAttribute("member", memberDto);

		// 편지봉투 생성 -> 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("member/memberDetail.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
