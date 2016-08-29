package com.kedu.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.project.dto.ProjectDto;

public class ProjectDao {
	private ProjectDao() {
		
	}
	
	private static ProjectDao instance = new ProjectDao();
	
	public static ProjectDao getInstance() {
		return instance;
	}
	
	// 프로젝트 등록
	public void insertProject(ProjectDto pDto) {
		String sql = "insert into project("
				+ "  pjtid"
				+ ", pjtnm"
				+ ", site"
				+ ", startdt"
				+ ", enddt"
				+ ", contents)"
				+ " values("
				+ " pjt_seq.nextval"
				+ ", ?"
				+ ", ?"
				+ ", ?"
				+ ", ?"
				+ ", ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pDto.getPjtnm());
			pstmt.setString(2, pDto.getSite());
			pstmt.setString(3, pDto.getStartdt());
			pstmt.setString(4, pDto.getEnddt());
			pstmt.setString(5, pDto.getContents());
		
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 프로젝트 리스트
	public List<ProjectDto> selectAllProject() {
		String sql = "select * from project order by pjtid desc";
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProjectDto pDto = new ProjectDto();
				
				pDto.setPjtid(rs.getInt("pjtid"));
				pDto.setPjtnm(rs.getString("pjtnm"));
				pDto.setSite(rs.getString("site"));
				pDto.setStartdt(rs.getString("startdt"));
				pDto.setEnddt(rs.getString("enddt"));
				pDto.setContents(rs.getString("contents"));
				
				
				list.add(pDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
