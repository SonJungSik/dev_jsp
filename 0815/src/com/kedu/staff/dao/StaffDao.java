package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kedu.staff.dto.StaffDto;

public class StaffDao {
	private StaffDao() {

	}

	private static StaffDao instance = new StaffDao();

	public static StaffDao getInstance() {
		return instance;
	}

	Connection getConnection() {
		Connection conn = null;
		Context initContext;

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/staff");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int userCheck(String userid, String pwd, String lev) {
		int result = 1;
		Connection conn = null;
		String sql = "select * from employees where userid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 비밀번호가 일치하고
				if (pwd.equals(rs.getString("pwd"))) {
					// 회원등급이 일치하면
					if (lev.equals(rs.getString("lev"))) {
						result = 2; // 관리자로 로그인 성공
						if (lev.equals("B")) {
							result = 3;
						}
					} else { // 레벨 불일치 로그인 실패
						result = 1;
					}
				} else { // 비밀번호 불일치 로그인 실패
					result = 0;
				}
			} else { // 아이디 불일치 로그인 실패
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public StaffDto getMember(String userid) {
		StaffDto stfDto = null;

		Connection conn = null;
		String sql = "select * from employees where userid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				stfDto = new StaffDto();
				stfDto.setUserid(rs.getString("userid"));
				stfDto.setPwd(rs.getString("pwd"));
				stfDto.setName(rs.getString("name"));
				stfDto.setLev(rs.getString("lev"));
				stfDto.setEnter(rs.getDate("enter"));
				stfDto.setGender(rs.getInt("gender"));
				stfDto.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return stfDto;

	}
	
	public void insertStaff(StaffDto stfDto) {
		String sql = "insert into employees values(?, ?, ?, ?, sysdate, ?, ?)";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?에 값 세팅
			pstmt.setString(1, stfDto.getUserid());
			pstmt.setString(2, stfDto.getPwd());
			pstmt.setString(3, stfDto.getName());
			pstmt.setString(4, stfDto.getLev());
			pstmt.setInt(5, stfDto.getGender());
			pstmt.setString(6, stfDto.getPhone());
			System.out.println(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
