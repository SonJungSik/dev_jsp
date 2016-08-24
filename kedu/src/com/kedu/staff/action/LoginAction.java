package com.kedu.staff.action;

import java.io.IOException;

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
		
		String stfid = request.getParameter("stfid");
		String pwd = request.getParameter("pwd");
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.userCheck(stfid, pwd);
		
		if(result == 2) {
			StaffDto sDto = sDao.getStaff(stfid);			
		}
		
	}

}
