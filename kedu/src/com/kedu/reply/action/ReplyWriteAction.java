package com.kedu.reply.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.reply.dao.ReplyDao;
import com.kedu.reply.dto.ReplyDto;

public class ReplyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contents = request.getParameter("contents");
		String stfid = request.getParameter("stfid");
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		
		ReplyDto rDto = new ReplyDto();
		rDto.setStfid(request.getParameter("stfid"));
		rDto.setNoticeno(Integer.parseInt(request.getParameter("noticeno")));
		rDto.setContents(request.getParameter("contents"));
		
		ReplyDao rDao = ReplyDao.getInstance();
		rDao.insertReply(rDto);
		
		
		System.out.println(contents);
		System.out.println(stfid);
		System.out.println(noticeno);
		
		
		
	}		

}
