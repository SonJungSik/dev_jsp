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
import com.kedu.reply.dao.ReplyDao;
import com.kedu.reply.dto.ReplyDto;

public class NoticeDetailAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/notice/noticeDetail.jsp";
		
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		ReplyDao rDao = ReplyDao.getInstance();
		
		nDao.updateReadCount(noticeno);
		
		NoticeDto nDto = nDao.selectOneNotice(noticeno);
		List<ReplyDto> replyList =  rDao.selectAllReply(noticeno);
		
		request.setAttribute("notice", nDto);
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
