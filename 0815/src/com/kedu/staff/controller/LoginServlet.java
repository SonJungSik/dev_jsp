package com.kedu.staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url = null;
		
		StaffDao stfDao = StaffDao.getInstance();
		int result = stfDao.userCheck(userid, pwd, lev);
		
		if(result == 2 || result == 3) {
			StaffDto stfDto = new StaffDto();
			stfDto = stfDao.getMember(userid);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", stfDto);
			session.setAttribute("result", result);
			url = "staff/main.jsp";
			
		} else {
			url = "staff/login.jsp";
			if (result == 1) {
				request.setAttribute("message", "레벨 불일치");
			} else if (result == 0) {
				request.setAttribute("message", "비밀번호 불일치");
			} else {
				request.setAttribute("message", "없는 사원");
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
