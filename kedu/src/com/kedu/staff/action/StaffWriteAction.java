package com.kedu.staff.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class StaffWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		StaffDto sDto = new StaffDto();
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		sDto.setStfid(Integer.parseInt(multi.getParameter("stfid")));
		sDto.setPwd(multi.getParameter("pwd"));
		sDto.setJumin(multi.getParameter("jumin1") + multi.getParameter("jumin2"));
		sDto.setPhone(multi.getParameter("phone"));
		sDto.setEntrydt(Timestamp.valueOf(multi.getParameter("entrydt")));
		sDto.setSalary(Integer.parseInt(multi.getParameter("salary")));
		sDto.setPic_img(multi.getFilesystemName("pic_img"));
		sDto.setPic_img_orn(multi.getOriginalFileName("pic_img"));
		sDto.setAddress(multi.getParameter("address"));
		sDto.setAdd_detail(multi.getParameter("add_detail"));
		sDto.setRegnm(multi.getParameter("regnm"));
		sDto.setJobid(Integer.parseInt(multi.getParameter("jobid")));
		sDto.setDeptid(Integer.parseInt(multi.getParameter("deptid")));
		
		StaffDao sDao = StaffDao.getInstance();
		sDao.insertStaff(sDto);
		
		new StaffListAction().execute(request, response);
	}

}
