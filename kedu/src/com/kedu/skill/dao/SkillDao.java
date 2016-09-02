package com.kedu.skill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.skill.dto.SkillDto;

public class SkillDao {
	private SkillDao() {
	}
	
	private static SkillDao instance = new SkillDao();
	
	public static SkillDao getInstance() {
		return instance;
	}
	
	public List<SkillDto> selectSkill() {
		String sql = "select * from skill order by skillno";
		
		List<SkillDto> list = new ArrayList<SkillDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SkillDto sDto = new SkillDto();
				
				sDto.setSkillno(rs.getInt("skillno"));
				sDto.setSkilltitle(rs.getString("skilltitle"));
				
				list.add(sDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	

	public void insertSkills(SkillDto sDto) {
		String sql = "insert into pjtskill values("
				+ "?, ?	)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String skill[] = sDto.getSkill();
		
		for (String string : skill) {
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, sDto.getPjtid());
				pstmt.setString(2, string);
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
	}

	public List<SkillDto> selectSkillCheck(String pjtid) {
		String sql = "select skillno from pjtskill where pjtid = ?";
		
		List<SkillDto> list = new ArrayList<SkillDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pjtid);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SkillDto sDto = new SkillDto();
				
				sDto.setSkillno(rs.getInt("skillno"));
				
				list.add(sDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
}
