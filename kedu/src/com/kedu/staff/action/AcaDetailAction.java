package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class AcaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stfid = request.getParameter("stfid");
		String acanm = request.getParameter("acanm");
		String entdt = request.getParameter("entdt");
		String grddt = request.getParameter("grddt");
		String major = request.getParameter("major");
		String grd_yn = request.getParameter("grd_yn");
		double grade = Double.parseDouble(request.getParameter("grade"));
		String regnm = request.getParameter("regnm");
		
		System.out.println("들어가니 : " + regnm);
		StaffDto sDto = new StaffDto();
		sDto.setAcanm(acanm);
		sDto.setEntdt(entdt);
		sDto.setGrddt(grddt);
		sDto.setMajor(major);
		sDto.setGrd_yn(grd_yn);
		sDto.setGrade(grade);
		sDto.setRegnm(regnm);
		sDto.setStfid(stfid);

		StaffDao sDao = StaffDao.getInstance();
		sDao.insertAca(sDto);
		
	}

}
