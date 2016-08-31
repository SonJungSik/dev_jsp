package com.kedu.zipcode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.zipcode.dto.ZipcodeDto;

public class ZipcodeDao {
	private static ZipcodeDao instance = new ZipcodeDao();
	
	public static ZipcodeDao getInstance() {
		return instance;
	}
	
	public List<ZipcodeDto> searchKeyDong(String dongName) {
		
		String sql = "select * from zipcode where dong like '%'||?||'%'";
		
		List<ZipcodeDto> list = new ArrayList<ZipcodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
    	try {
    		conn = DBManager.getConnection();
     		pstmt = conn.prepareStatement(sql);
     		
     		System.out.println("dongName : " + dongName);
     		pstmt.setString(1, dongName);
    		
    		rs = pstmt.executeQuery();
    		
    		
    		while(rs.next()){
    			ZipcodeDto zDto = new ZipcodeDto();
    			
    			zDto.setZipcode(rs.getString("zipcode"));
    			zDto.setSido(rs.getString("sido"));
    			zDto.setGugun(rs.getString("gugun"));
    			zDto.setDong(rs.getString("dong"));
    			zDto.setRi(rs.getString("ri"));
    			zDto.setBldg(rs.getString("bldg"));
    			zDto.setBunji(rs.getString("bungi"));
    			zDto.setSeq(rs.getString("seq"));
    			
    			System.out.println(zDto);
    			list.add(zDto);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
			DBManager.close(conn, pstmt, rs);
		}
             
    	return list;  
	}
	
}
