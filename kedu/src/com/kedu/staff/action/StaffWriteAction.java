package com.kedu.staff.action;

import java.io.IOException;

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
		System.out.println("multi 생성전");			
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		System.out.println("multi 생성");
		StaffDto sDto = new StaffDto();
		sDto.setStfid(multi.getParameter("stfid"));
		sDto.setStfnm(multi.getParameter("stfnm"));
		sDto.setPwd(multi.getParameter("pwd"));
		sDto.setJumin(multi.getParameter("jumin1") + multi.getParameter("jumin2"));
		sDto.setPhone(multi.getParameter("phone"));
		sDto.setEntrydt(multi.getParameter("entrydt"));
		sDto.setSalary(Integer.parseInt(multi.getParameter("salary")));
		sDto.setPic_img(multi.getFilesystemName("pic_img"));
		sDto.setPic_img_orn(multi.getOriginalFileName("pic_img"));
		sDto.setAddress(multi.getParameter("address"));
		sDto.setAdd_detail(multi.getParameter("add_detail"));
		
		sDto.setJobid(Integer.parseInt(multi.getParameter("jobid")));
		sDto.setDeptid(Integer.parseInt(multi.getParameter("deptid")));
		sDto.setIsmgr(multi.getParameter("ismgr"));

		sDto.setRegnm("손정식");				// 등록자 나중에 세션값 받아서 자동 입력
		StaffDao sDao = StaffDao.getInstance();
		sDao.insertStaff(sDto);
		
		System.out.println("insert 성공");
		
		new MainAction().execute(request, response);
	}

}
