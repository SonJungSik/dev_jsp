package com.kedu.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class StaffDetailFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/staff/staffDetail.jsp";
		String stfid = request.getParameter("stfid");
		

		StaffDao sDao = StaffDao.getInstance();
	
		List<StaffDto> detailList = sDao.getDetail(stfid);
		
		request.setAttribute("stfid", stfid);
		request.setAttribute("detailList", detailList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
