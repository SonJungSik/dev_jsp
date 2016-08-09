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
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1. 회원정보 저장 request -> MemberDto
		MemberDto memberDto = new MemberDto();

		memberDto.setName(request.getParameter("name"));
		memberDto.setUserid(request.getParameter("userid"));
		memberDto.setPwd(request.getParameter("pwd"));
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setPhone(request.getParameter("phone"));
		memberDto.setAdmin(Integer.parseInt(request.getParameter("admin")));

		// 2. DB 처리 : DAO의 insertMember(MemberDto) 호출
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto);

		// 3. 결과 Request 저장 : 결과 int <- 1 : 정상처리, 1이 아니면 -> 다시 입력
		String resultUrl = "insertMemberOk.jsp";
		if (result != 1) {
			request.setAttribute("memberDto", memberDto);
			resultUrl = "addMemberForm.jsp";
			
		}

		// 4. 편지봉투 생성 -> 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("member/" + resultUrl);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
