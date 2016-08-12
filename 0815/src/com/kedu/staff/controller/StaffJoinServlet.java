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
 * Servlet implementation class StaffJoinServlet
 */
@WebServlet("/staff.do")
public class StaffJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StaffDto stfDto = (StaffDto) session.getAttribute("loginUser");
		Integer result = (Integer) session.getAttribute("result");
		if(stfDto != null && result == 2) {
			String url = "staff/staffjoin.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StaffDto stfDto = new StaffDto();
		stfDto.setUserid(request.getParameter("userid"));
		stfDto.setPwd(request.getParameter("pwd"));
		stfDto.setName(request.getParameter("name"));
		stfDto.setLev(request.getParameter("lev"));
		stfDto.setGender(Integer.parseInt(request.getParameter("gender")));
		stfDto.setPhone(request.getParameter("phone"));
		
		StaffDao stfDao = StaffDao.getInstance();
		stfDao.insertStaff(stfDto);
		
		request.setAttribute("staff", stfDto);
		request.setAttribute("message", "회원 등록에 성공했습니다.");
		String url = "staff/joinsuccess.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
