package com.kedu.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kedu.board.dto.BoardDto;
import com.kedu.common.DBManager;

public class BoardDao {
	private BoardDao() {

	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}

	// 총 레코드 수를 구한다.
	public int totalRecord() {
		int totalRecord = 0;
		String sql = "select count(*) from board";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRecord = rs.getInt(1);

		} catch (SQLException e) {
			DBManager.close(conn, pstmt, rs);
		}
		return totalRecord;
	}

	// 페이징 처리 리스트
	public List<BoardDto> selectPageBoards() {
		String sql = "select * from (" + "select rownum r, a.* from (" + "select * from board order by num desc) a) "
				+ "where r between ? and ?";

		List<BoardDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
				
		} catch (SQLException e) {
			DBManager.close(conn, pstmt, rs);
		}

	}

	public List<BoardDto> selectAllBoards() {
		String sql = "select * from board order by num desc";

		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardDto bDto = new BoardDto();

				bDto.setNum(rs.getInt("num"));
				bDto.setName(rs.getString("name"));
				bDto.setEmail(rs.getString("email"));
				bDto.setPass(rs.getString("pass"));
				bDto.setTitle(rs.getString("title"));
				bDto.setContent(rs.getString("content"));
				bDto.setReadcount(rs.getInt("readcount"));
				bDto.setWritedate(rs.getTimestamp("writedate"));

				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public void insertBoard(BoardDto bDto) {
		String sql = "insert into board(" + "num, name, email, pass, title, content) "
				+ "values(board_seq.nextval, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bDto.getName());
			pstmt.setString(2, bDto.getEmail());
			pstmt.setString(3, bDto.getPass());
			pstmt.setString(4, bDto.getTitle());
			pstmt.setString(5, bDto.getContent());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount+1 where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용보기 : 글번호로 찾아온다 : 실패 null
	public BoardDto selectOneBoardByNum(String num) {
		String sql = "select * from board where num = ?";

		BoardDto bDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bDto = new BoardDto();

				bDto.setNum(rs.getInt("num"));
				bDto.setName(rs.getString("name"));
				bDto.setPass(rs.getString("pass"));
				bDto.setEmail(rs.getString("email"));
				bDto.setTitle(rs.getString("title"));
				bDto.setContent(rs.getString("content"));
				bDto.setWritedate(rs.getTimestamp("writedate"));
				bDto.setReadcount(rs.getInt("readcount"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return bDto;
	}

	public void updateBoard(BoardDto bDto) {
		String sql = "update board set name=?, email=?, pass=?, " + "title=?, content=? where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bDto.getName());
			pstmt.setString(2, bDto.getEmail());
			pstmt.setString(3, bDto.getPass());
			pstmt.setString(4, bDto.getTitle());
			pstmt.setString(5, bDto.getContent());
			pstmt.setInt(6, bDto.getNum());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public BoardDto checkPassWord(String pass, String num) {
		String sql = "select * from board where pass=? and num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto bDto = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pass);
			pstmt.setString(2, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bDto = new BoardDto();

				bDto.setNum(rs.getInt("num"));
				bDto.setName(rs.getString("name"));
				bDto.setEmail(rs.getString("email"));
				bDto.setPass(rs.getString("pass"));
				bDto.setTitle(rs.getString("title"));
				bDto.setReadcount(rs.getInt("readcount"));
				bDto.setWritedate(rs.getTimestamp("writedate"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bDto;
	}

	public void deleteBoard(String num) {
		String sql = "delete board where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
