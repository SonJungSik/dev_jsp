package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kedu.common.db.DBManager;
import com.kedu.staff.dto.StaffDto;

public class StaffDao {
	private static StaffDao instance = new StaffDao();
	
	public static StaffDao getInstance() {
		if (instance == null) {
			instance = new StaffDao();
		}
		return instance;
	}
	
	// 사원 등록 기본정보
	public void insertStaff(StaffDto sDto) {
		String sql = "insert into staff("
				+ "stfid, "		// 사원 id
				+ "pwd, "		// 사원 비밀번호
				+ "ismgr, "		// 관리자 여부
				+ "stfnm, "		// 사원 이름
				+ "jumin, "		// 주민번호
				+ "phone, "		// 전화번호
				+ "entrydt, "
				+ "salary, "
				+ "pic_img, "
				+ "pic_img_orn, "
				+ "address, "
				+ "add_detail, "
				+ "regdt, "
				+ "regnm, "
				+ "jobid, "
				+ "deptid) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sDto.getStfid());
			pstmt.setString(2, sDto.getPwd());
			pstmt.setString(3, sDto.getIsmgr());
			pstmt.setString(4, sDto.getJumin());
			pstmt.setString(5, sDto.getPhone());
			pstmt.setTimestamp(6, sDto.getEntrydt());
			pstmt.setInt(7, sDto.getSalary());
			pstmt.setString(8, sDto.getPic_img());
			pstmt.setString(9, sDto.getPic_img_orn());
			pstmt.setString(10, sDto.getAddress());
			pstmt.setString(11, sDto.getAdd_detail());
			pstmt.setString(12, sDto.getRegnm());
			pstmt.setInt(13, sDto.getJobid());
			pstmt.setInt(14, sDto.getDeptid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
