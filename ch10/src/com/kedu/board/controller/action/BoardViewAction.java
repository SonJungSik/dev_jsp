package com.kedu.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardView.jsp";
		
		String num = request.getParameter("num");
		
		BoardDao bDao = BoardDao.getInstance();
		
		bDao.updateReadCount(num);
		
		BoardDto bDto = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", bDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
