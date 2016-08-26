package com.kedu.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dto.NoticeDto;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/notice/noticeList.jsp";
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		List<NoticeDto> noticeList = nDao.selectAllNotice();
		System.out.println(noticeList);
		request.setAttribute("noticeList", noticeList);
		
		RequestDispatcher dispathcer= request.getRequestDispatcher(url);
		dispathcer.forward(request, response);
	}

}
