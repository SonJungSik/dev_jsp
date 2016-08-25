package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/index.jsp";
		String stfid = request.getParameter("stfid");
		String pwd = request.getParameter("pwd");
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.userCheck(stfid, pwd);
		
		if(result == 2) {
			StaffDto sDto = sDao.getStaff(stfid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", sDto);
			url = "main.jsp";
			
		} else if (result == 1) {
			StaffDto sDto = sDao.getStaff(stfid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", sDto);
			url = "main.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
