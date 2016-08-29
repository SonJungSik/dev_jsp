package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dto.NoticeDto;

public class NoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/notice/noticeUpdate.jsp";
		
		String noticeno = request.getParameter("noticeno");

		NoticeDao nDao = NoticeDao.getInstance();
		
		nDao.updateReadCount(noticeno);
		
		NoticeDto nDto = nDao.selectOneNotice(noticeno);
		
		request.setAttribute("notice", nDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
