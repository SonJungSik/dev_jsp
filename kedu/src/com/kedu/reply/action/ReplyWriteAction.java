package com.kedu.reply.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;

public class ReplyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply_content = request.getParameter("reply_content");
		String emp_name=request.getParameter("emp_name");
		System.out.println("reply_content: " + reply_content);
		System.out.println("emp_name: " + emp_name);
		
	}		

}
