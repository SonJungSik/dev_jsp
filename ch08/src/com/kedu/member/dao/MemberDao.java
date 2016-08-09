package com.kedu.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kedu.member.dto.MemberDto;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:testdb";
	private final static String UID = "kedu";
	private final static String PASS = "1234";
	
	// 회원등록 메소드
	public int insertMember(MemberDto memberDto){
		StringBuilder insertMemberSql = new StringBuilder();
		insertMemberSql.append("insert into member	");
		insertMemberSql.append("values				");
		insertMemberSql.append("(					");
		insertMemberSql.append("?,?,?,?,?,?			");
		insertMemberSql.append(")					");
		int result = 0;
		
		try {
			// 1. 드라이버 등록 -> 생략 가능
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성 -> new Connection() X
			conn = DriverManager.getConnection(URL, UID, PASS);

			// 3. Statement 생성 
			pstmt = conn.prepareStatement(insertMemberSql.toString());
			
			// ? -> Setting
			pstmt.setString(1, memberDto.getName());
			pstmt.setString(2, memberDto.getUserid());
			pstmt.setString(3, memberDto.getPwd());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5, memberDto.getPhone());
			pstmt.setInt(6, memberDto.getAdmin());
			
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			try {
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
	// 특정 아이디 검색 1명 리턴하는 메소드
	public MemberDto selectOneByIdMember(String userid) {
		MemberDto memberDto = new MemberDto();
		String selectOneByIdMember = "select * from member where userid='"+userid +"'";
		try {
			// 1. 드라이버 등록 -> 생략 가능
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성 -> new Connection() X
			conn = DriverManager.getConnection(URL, UID, PASS);

			// 3. Statement 생성 
			stmt = conn.createStatement();

			// 4. Statement 실행 -> 실행할 쿼리가 Select인 경우 executeQuery(쿼리문);
			// 					-> 실핼할 쿼리가 Select가 아닌경우 executeUpdate(쿼리문);
			//					-> ResultSet 반환
			rs = stmt.executeQuery(selectOneByIdMember);
			rs.next();
			memberDto.setName(rs.getString("name"));
			memberDto.setUserid(rs.getString("userid"));
			memberDto.setPwd(rs.getString("pwd"));
			memberDto.setEmail(rs.getString("email"));
			memberDto.setPhone(rs.getString("phone"));
			memberDto.setAdmin(rs.getInt("admin"));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDto;
	}

	// 모든 회원 리턴하는 메소드
	public ArrayList<MemberDto> selectAllMember() {
		ArrayList<MemberDto> allMemberList = new ArrayList<>();
		String allMemberSql = "select * from member";

		try {
			// 1. 드라이버 등록 -> 생략 가능
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성 -> new Connection() X
			conn = DriverManager.getConnection(URL, UID, PASS);

			// 3. Statement 생성 -> 실행할 쿼리가 Select인 경우 executeQuery(쿼리문);
			// -> 실핼할 쿼리가 Select가 아닌경우 executeUpdate(쿼리문);
			stmt = conn.createStatement();

			// 4. Statement 실행
			rs = stmt.executeQuery(allMemberSql);

			// ResultSet -> ArrayList<MemberDto> 생성
			while (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setName(rs.getString("name"));
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setPwd(rs.getString("pwd"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setAdmin(rs.getInt("admin"));

				// arrayList에 저장
				allMemberList.add(memberDto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allMemberList;
	}
}
