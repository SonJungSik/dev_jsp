package com.kedu.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.member.dao.MemberDao;
import com.kedu.member.dto.MemberDto;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스 처리
		MemberDao memberDao = new MemberDao();

		// ArrayList<MemberDto> memberList = new ArrayList<>();
		// memberList = memberDao.selectAllMember();
		// 아래처럼 한줄처리 가능 <- 확인
		ArrayList<MemberDto> memberList = memberDao.selectAllMember();
		
		// 처리결과 Request 저장
		request.setAttribute("memberList", memberList);
		
		// 편지봉투 생성 -> 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("member/allMember.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
