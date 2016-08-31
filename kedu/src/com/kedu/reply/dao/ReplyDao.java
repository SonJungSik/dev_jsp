package com.kedu.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.reply.dto.ReplyDto;

public class ReplyDao {
	private ReplyDao() {
	}
	
	private static ReplyDao instance = new ReplyDao();
	
	public static ReplyDao getInstance() {
		return instance;
	}
	
	public void insertReply(ReplyDto rDto) {
		String sql = "insert into reply("
				+ "  replyno"
				+ ", noticeno"
				+ ", stfid"
				+ ", contents"
				+ ") "
				+ "values(reply_seq.nextval"
				+ ", ?"
				+ ", ?"
				+ ", ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rDto.getNoticeno());
			pstmt.setString(2, rDto.getStfid());
			pstmt.setString(3, rDto.getContents());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<ReplyDto> selectAllReply(int noticeno) {
		String sql = "select s.stfnm, r.contents, r.regdt "
				+ "from reply r, staff s "
				+ "where r.stfid = s.stfid "
				+ "and r.noticeno = ? "
				+ "order by r.replyno";
		
		List<ReplyDto> list = new ArrayList<ReplyDto>();
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReplyDto rDto = new ReplyDto();
				
				rDto.setStfnm(rs.getString("stfnm"));
				rDto.setContents(rs.getString("contents"));
				rDto.setRegdt(rs.getString("regdt"));
				
				list.add(rDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
