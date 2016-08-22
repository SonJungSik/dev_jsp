package com.kedu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.member.dto.MemberDto;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	public List<MemberDto> selectAllMembers() {
		String sql = "select * from member";

		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberDto bDto = new MemberDto();

				bDto.setName(rs.getString("name"));
				bDto.setEmail(rs.getString("email"));
				bDto.setPwd(rs.getString("pwd"));

				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}
	public void insertMember(MemberDto mDto) {
		String sql = "insert into member(" + "name, email, pwd) "
				+ "values(?, ?, ? )";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mDto.getName());
			pstmt.setString(2, mDto.getEmail());
			pstmt.setString(3, mDto.getPwd());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}