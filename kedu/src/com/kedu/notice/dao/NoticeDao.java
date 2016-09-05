package com.kedu.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.notice.dto.NoticeDto;

public class NoticeDao {
	private NoticeDao() {

	}

	private static NoticeDao instance = new NoticeDao();

	public static NoticeDao getInstance() {
		return instance;
	}

	public void insertNotice(NoticeDto nDto) {
		String sql = "insert into notice(" + "stfid, noticeno, noticetitle, contents, deptid) "
				+ "values(?, notice_seq.nextval, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nDto.getStfid());
			pstmt.setString(2, nDto.getNoticetitle());
			pstmt.setString(3, nDto.getContents());
			pstmt.setInt(4, nDto.getDeptid());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(int noticeno) {
		String sql = "update notice set readcount=readcount+1 where noticeno=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeno);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 공지사항 리스트
	public List<NoticeDto> selectAllNotice() {
		String sql = "select n.noticeno" + ", n.noticetitle " + ", s.stfnm " + ", d.deptnm " + ", n.regdt "
				+ ", n.readcount " + " FROM STAFF s, DEPARTMENTS d, NOTICE n " + "WHERE n.STFID = s.STFID "
				+ " AND d.DEPTID = n.DEPTID " + " order by n.noticeno desc";

		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeDto nDto = new NoticeDto();

				nDto.setNoticeno(rs.getInt("noticeno"));
				nDto.setNoticetitle(rs.getString("noticetitle"));
				nDto.setStfnm(rs.getString("stfnm"));
				nDto.setDeptnm(rs.getString("deptnm"));
				nDto.setRegdt(rs.getString("regdt").substring(0, 10));
				nDto.setReadcount(rs.getInt("readcount"));

				list.add(nDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 공지사항 상세보기
	public NoticeDto selectOneNotice(int noticeno) {
		String sql = "select " + "s.stfnm," + "n.stfid, " + "n.noticeno, " + "n.noticetitle, " + "n.contents, "
				+ "n.regdt, " + "n.readcount, " + "n.deptid, " + "d.deptnm "
				+ "from notice n, staff s, departments d where " + "n.stfid = s.stfid and " + "n.deptid = d.deptid and "
				+ "n.noticeno = ?";

		NoticeDto nDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nDto = new NoticeDto();

				nDto.setStfnm(rs.getString("stfnm"));
				nDto.setStfid(rs.getString("stfid"));
				nDto.setNoticeno(rs.getInt("noticeno"));
				nDto.setNoticetitle(rs.getString("noticetitle"));
				nDto.setContents(rs.getString("contents"));
				nDto.setRegdt(rs.getString("regdt"));
				nDto.setReadcount(rs.getInt("readcount"));
				nDto.setDeptid(rs.getInt("deptid"));
				nDto.setDeptnm(rs.getString("deptnm"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nDto;
	}

	// 게시판 수정
	public void updateNotice(NoticeDto nDto) {
		String sql = "update notice set stfid=?, noticetitle = ?, contents = ?, deptid =? " + "where noticeno = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nDto.getStfid());
			pstmt.setString(2, nDto.getNoticetitle());
			pstmt.setString(3, nDto.getContents());
			pstmt.setInt(4, nDto.getDeptid());
			pstmt.setInt(5, nDto.getNoticeno());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}
	}

	// 공지사항 삭제
	public void deleteNotice(int noticeno) {
		String sql = "delete notice where noticeno=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, noticeno);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<NoticeDto> selectMainNotice() {
		String sql = "select n.noticeno" + ", n.noticetitle " + ", s.stfnm " + ", d.deptnm " + ", n.regdt "
				+ ", n.readcount " + " FROM STAFF s, DEPARTMENTS d, NOTICE n " + "WHERE n.STFID = s.STFID "
				+ " AND d.DEPTID = n.DEPTID " + " order by n.noticeno desc";

		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeDto nDto = new NoticeDto();

				nDto.setNoticeno(rs.getInt("noticeno"));
				nDto.setNoticetitle(rs.getString("noticetitle"));
				nDto.setStfnm(rs.getString("stfnm"));
				nDto.setDeptnm(rs.getString("deptnm"));
				nDto.setRegdt(rs.getString("regdt"));
				nDto.setReadcount(rs.getInt("readcount"));

				list.add(nDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
