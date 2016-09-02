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
	public ProjectDto getPjtid(){
		String sql = "SELECT project_SEQ  FROM dual";
		ProjectDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pDto = new ProjectDto();
				
				pDto.setPjtid(rs.getString("project_SEQ"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pDto;
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
				+ " ?"
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
			pstmt.setString(1, pDto.getPjtid());
			pstmt.setString(2, pDto.getPjtnm());
			pstmt.setString(3, pDto.getSite());
			pstmt.setString(4, pDto.getStartdt().substring(0, 10));
			pstmt.setString(5, pDto.getEnddt().substring(0, 10));
			pstmt.setString(6, pDto.getContents());
		
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
				
				pDto.setPjtid(rs.getString("pjtid"));
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
	public ProjectDto selectOneProject(String pjtid) {
		String sql = "select * from project where pjtid = ?";
		
		ProjectDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pjtid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pDto = new ProjectDto();
				
				pDto.setPjtid(rs.getString("pjtid"));
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
			pstmt.setString(6, pDto.getPjtid());
			
			pstmt.executeUpdate();
		} catch (SQLException  e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	// 페이징 처리를 해보자(총레코드수 반환)
	public int totalpageProject() {
		String sql = "select count(*) from project";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalRecord = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRecord = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return totalRecord;
	}
	static int numPerPage = 10; // 한 페이지에서 보일 레코드수
	static int totalPage = 0;	// 총 페이지수

	// 현재 페이지 구하기
	public List<ProjectDto> selectCurPageProject(int start, int end) {
		String sql = "SELECT pjtid, pjtnm, site, startdt, enddt " +
					"FROM  (SELECT ROWNUM r, a. * FROM (SELECT pjtid, pjtnm, site, startdt, enddt " +
					" FROM PROJECT ORDER BY pjtid desc) a) WHERE r BETWEEN ? AND ?";
		
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProjectDto pDto = new ProjectDto();
				
				pDto.setPjtid(rs.getString("pjtid"));
				pDto.setPjtnm(rs.getString("pjtnm"));
				pDto.setSite(rs.getString("site"));
				pDto.setStartdt(rs.getString("startdt").substring(0, 10));
				pDto.setEnddt(rs.getString("enddt").substring(0, 10));
				
				
				list.add(pDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
