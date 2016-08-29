package com.kedu.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
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
			pstmt.setString(3, pDto.getStartdt().substring(0, 10));
			pstmt.setString(4, pDto.getEnddt().substring(0, 10));
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
				pDto.setStartdt(rs.getString("startdt").substring(0, 10));
				pDto.setEnddt(rs.getString("enddt").substring(0, 10));
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

	// 프로젝트 상세보기
	public ProjectDto selectOneProject(int pjtid) {
		String sql = "select * from project where pjtid = ?";
		
		ProjectDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pjtid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pDto = new ProjectDto();
				
				pDto.setPjtid(rs.getInt("pjtid"));
				pDto.setPjtnm(rs.getString("pjtnm"));
				pDto.setSite(rs.getString("site"));
				pDto.setStartdt(rs.getString("Startdt").substring(0, 10));
				pDto.setEnddt(rs.getString("enddt").substring(0, 10));
				pDto.setContents(rs.getString("contents"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pDto;
	}

	public void updateProject(ProjectDto pDto) {
		String sql = "update project set "
				+ "  pjtnm=?"
				+ ", site=?"
				+ ", startdt=?"
				+ ", enddt=?"
				+ ", contents=?"
				+ " where pjtid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pDto.getPjtnm());
			pstmt.setString(2, pDto.getSite());
			pstmt.setString(3, pDto.getStartdt().substring(0, 10));
			pstmt.setString(4, pDto.getEnddt().substring(0, 10));
			pstmt.setString(5, pDto.getContents());
			pstmt.setInt(6, pDto.getPjtid());
			
			pstmt.executeUpdate();
		} catch (SQLException  e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
