package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class StaffUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/staff/staffUpdate.jsp";
		System.out.println("되니?");
		String stfid = request.getParameter("stfid");
		System.out.println(stfid);		
		StaffDao sDao = StaffDao.getInstance();
		
		StaffDto sDto = sDao.selectOneStaff(stfid);
		System.out.println(sDto);
		
		request.setAttribute("staff", sDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
