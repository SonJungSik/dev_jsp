package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.notice.dao.NoticeDao;

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.deleteNotice(noticeno);
		
		new NoticeListAction().execute(request, response);
	}

}
