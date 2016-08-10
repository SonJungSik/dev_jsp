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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDao mDao = MemberDao.getInstance();
		
		MemberDto mDto = mDao.getMember(userid);
		request.setAttribute("mDto", mDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 폼에서 입력한 회원 정보 얻어오기
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberDto mDto = new MemberDto();
		mDto.setUserid(userid);
		mDto.setPwd(pwd);
		mDto.setEmail(email);
		mDto.setPhone(phone);
		mDto.setAdmin(Integer.parseInt(admin));
		
		MemberDao mDao = MemberDao.getInstance();
		
		mDao.updateMember(mDto);
		response.sendRedirect("login.do");
		
	}

}
