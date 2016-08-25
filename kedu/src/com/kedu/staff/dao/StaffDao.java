package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				+ "entrydt, "	// 입사일
				+ "salary, "	// 연봉
				+ "pic_img, "		// 사진
				+ "pic_img_orn, "	// 사진
				+ "address, "		// 주소
				+ "add_detail, "	// 상세주소
				+ "regdt, "			// 등록일
				+ "regnm, "			// 등록자
				+ "jobid, "			// 직급
				+ "deptid) "		// 부서
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
				
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sDto.getStfid());
			pstmt.setString(2, sDto.getPwd());
			pstmt.setString(3, sDto.getIsmgr());
			pstmt.setString(4, sDto.getStfnm());
			pstmt.setString(5, sDto.getJumin());
			pstmt.setString(6, sDto.getPhone());
			pstmt.setString(7, sDto.getEntrydt());
			pstmt.setInt(8, sDto.getSalary());
			pstmt.setString(9, sDto.getPic_img());
			pstmt.setString(10, sDto.getPic_img_orn());
			pstmt.setString(11, sDto.getAddress());
			pstmt.setString(12, sDto.getAdd_detail());
			pstmt.setString(13, sDto.getRegnm());
			pstmt.setInt(14, sDto.getJobid());
			pstmt.setInt(15, sDto.getDeptid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 전체 사원 리스트보기
	public List<StaffDto> selectAllStaff() {
		String sql = "select s.stfid, s.stfnm, j.jobnm, d.deptnm, s.phone, s.entrydt "
				+ "from departments d, staff s, jobs j "
				+ "where d.deptid = s.deptid "
				+ "and j.jobid=s.jobid "
				+ "order by s.stfid";
		
		List<StaffDto> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				StaffDto sDto = new StaffDto();
				
				
				sDto.setStfid(rs.getString("stfid"));
				sDto.setStfnm(rs.getString("stfnm"));
				sDto.setJobnm(rs.getString("jobnm"));
				sDto.setDeptnm(rs.getString("deptnm"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setEntrydt(rs.getString("entrydt"));
				
				list.add(sDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// 로그인 인증시 사용
	public int userCheck(String stfid, String pwd) {
		int result = -1;
		String sql = "select pwd, ismgr from staff where stfid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stfid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if (rs.getString("pwd") !=null && rs.getString("pwd").equals(pwd)) {
					if(rs.getString("ismgr").equals("Y")) {
						result = 2; // 관리자
					} else {
						result = 1; // 사용자
					}
				} else {
					result = 0; // 비번틀림
				}
					
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return result;
	}

	// 사원 정보 세션 저장용
	public StaffDto getStaff(String stfid) {
		String sql = "select stfid, stfnm, ismgr from staff where stfid = ?";
		
		StaffDto sDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stfid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sDto = new StaffDto();
				sDto.setStfid(rs.getString("stfid"));
				sDto.setStfnm(rs.getString("stfnm"));
				sDto.setIsmgr(rs.getString("ismgr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return sDto;
	}
	
	// 사원 정보 업데이트
	public void updateStaff(StaffDto sDto) {
		
		String sql = "update staff set "
				+ "stfid=?, "
				+ "pwd=?, "
				+ "ismgr=?, "
				+ "stfnm=?, "
				+ "jumin=?, "
				+ "phone=?, "
				+ "entrydt=?, "
				+ "resigndt=?, "
				+ "salary=?, "
				+ "pic_img=?, "
				+ "pic_img_orn=?, "
				+ "address=?, "
				+ "add_detail=?, "
				+ "regdt=sysdate, "
				+ "jobid=?, "
				+ "deptid=? "
				+ "where stfid= ?";
		
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

	
	// 사원 정보 업데이트폼에 뿌리기
	public StaffDto selectOneStaff(String stfid) {
	
		String sql = "select * from staff where stfid = ?";
		
		StaffDto sDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stfid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sDto = new StaffDto();
				
				sDto.setStfid(rs.getString("stfid"));
				sDto.setPwd(rs.getString("pwd"));
				sDto.setIsmgr(rs.getString("ismgr"));
				sDto.setStfnm(rs.getString("stfnm"));
				sDto.setJumin(rs.getString("jumin"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setEntrydt(rs.getString("entrydt"));
				sDto.setResigndt(rs.getString("resigndt"));
				sDto.setSalary(rs.getInt("salary"));
				sDto.setPic_img(rs.getString("pic_img"));
				sDto.setPic_img_orn(rs.getString("pic_img_orn"));
				sDto.setAddress(rs.getString("address"));
				sDto.setAdd_detail(rs.getString("add_detail"));
				sDto.setRegdt(rs.getString("regdt"));
				sDto.setRegnm(rs.getString("regnm"));
				sDto.setJobid(rs.getInt("jobid"));
				sDto.setDeptid(rs.getInt("deptid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return sDto;
	}
}
