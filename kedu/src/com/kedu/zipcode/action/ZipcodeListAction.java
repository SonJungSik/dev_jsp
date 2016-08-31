package com.kedu.zipcode.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kedu.common.action.Action;
import com.kedu.zipcode.dao.ZipcodeDao;
import com.kedu.zipcode.dto.ZipcodeDto;

public class ZipcodeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dong = request.getParameter("dong");
		
		System.out.println("dong : " + dong);
		
		ZipcodeDao zDao = ZipcodeDao.getInstance();
		
		List<ZipcodeDto> zipcodeList = zDao.searchKeyDong(dong);
		
		String result = new Gson().toJson(zipcodeList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
		System.out.println(result);
		
	}

}
