package com.kedu.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto bDto = new BoardDto();
		
		bDto.setName(request.getParameter("name"));
		bDto.setPass(request.getParameter("pass"));
		bDto.setEmail(request.getParameter("email"));
		bDto.setTitle(request.getParameter("title"));
		bDto.setContent(request.getParameter("content"));
		
		BoardDao bDao = BoardDao.getInstance();
		bDao.insertBoard(bDto);
		
		new BoardListAction().execute(request, response);	
	}

}
