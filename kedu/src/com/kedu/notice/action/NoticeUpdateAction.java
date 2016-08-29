package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dto.NoticeDto;

public class NoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDto nDto= new NoticeDto();
		
		nDto.setDeptid(Integer.parseInt(request.getParameter("deptid")));
		nDto.setNoticetitle(request.getParameter("noticetitle"));
		nDto.setContents(request.getParameter("contents"));
		nDto.setStfid(request.getParameter("stfid"));
		nDto.setNoticeno(Integer.parseInt(request.getParameter("noticeno")));
		
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.updateNotice(nDto);
		
		new NoticeListAction().execute(request, response);
	}

}
