package com.kedu.staff.action;

import java.util.List;

import javax.servlet.RequestDispatcher;

import com.kedu.common.action.Action;
import com.kedu.common.util.PageDto;
import com.kedu.common.util.PageHelper;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class StaffListAction implements Action {
	public void execute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		String url = "/staff/staffList.jsp";
		
		int curPage = (request.getParameter("curPage") == null) ? 1 : Integer.parseInt(request.getParameter("curPage"));
		int numPerPage = 10;
		int totalRecord = 0;
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		int start = (curPage - 1) * numPerPage + 1;
		int end = start + numPerPage - 1;
		
		if(keyField == null) {
			keyField = "";
		}
		if(keyWord == null) {
			keyWord = "";
		}
		
						
		StaffDao sDao = StaffDao.getInstance();
		totalRecord = sDao.totalPageStaff(keyField, keyWord);
		
		List<StaffDto> staffList = sDao.selectCurPageStaff(start, end, keyField, keyWord);
		PageDto pageDto = PageHelper.getBlockGroup(curPage, numPerPage, totalRecord);
		
		request.setAttribute("staffList", staffList);
		request.setAttribute("pageDto", pageDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	};
}
