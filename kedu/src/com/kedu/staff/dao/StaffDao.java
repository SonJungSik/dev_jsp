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
	
	public void insertStaff(StaffDto sDto) {
		String sql = "insert into staff(stfid, "
				+ "pwd, "
				+ "ismgr, "
				+ "stfnm, "
				+ "jumin, "
				+ "phone, "
				+ "entrydt, "
				+ "resigndt, "
				+ "salary, "
				+ "pic_img, "
				+ "pic_img_orn, "
				+ "address, "
				+ "add_detail, "
				+ "regdt, "
				+ "regnm, "
				+ "jobid, "
				+ "deptid) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
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
	
	public void insertStaff(StaffDto sDto) {
		String sql = "insert into staff(stfid, "
				+ "pwd, "
				+ "ismgr, "
				+ "stfnm, "
				+ "jumin, "
				+ "phone, "
				+ "entrydt, "
				+ "resigndt, "
				+ "salary, "
				+ "pic_img, "
				+ "pic_img_orn, "
				+ "address, "
				+ "add_detail, "
				+ "regdt, "
				+ "regnm, "
				+ "jobid, "
				+ "deptid) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
