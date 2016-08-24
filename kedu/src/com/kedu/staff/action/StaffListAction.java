package com.kedu.staff.action;

import java.util.List;

import javax.servlet.RequestDispatcher;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class StaffListAction implements Action {
	public void execute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		String url = "/staff/staffList.jsp";
		
		StaffDao sDao = StaffDao.getInstance();
		
		List<StaffDto> staffList = sDao.selectAllStaff();
		
		request.setAttribute("staffList", staffList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	};
}
