package com.kedu.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kedu.product.dto.ProductDto;

public class ProductDao {
	private ProductDao() {

	}

	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	public List<ProductDto> selectAllProducts() {
		String sql = "select * from product order by code desc";
		List<ProductDto> list = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto pDto = new ProductDto();
				pDto.setCode(rs.getInt("code"));
				pDto.setCode(rs.getInt("code"));
				pDto.setName(rs.getString("name"));
				pDto.setPrice(rs.getInt("price"));
				pDto.setProduct_img(rs.getString("product_img"));
				pDto.setProduct_img_orn(rs.getString("product_img_orn"));
				pDto.setDescription(rs.getString("description"));
				list.add(pDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public void insertProduct(ProductDto pDto) {
		String sql = "insert into product values(product_seq.nextval,"
				+ " ?, ? ,?, ? ,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pDto.getName());
			pstmt.setInt(2, pDto.getPrice());
			pstmt.setString(3, pDto.getProduct_img());
			pstmt.setString(4, pDto.getProduct_img_orn());
			pstmt.setString(5, pDto.getDescription());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ProductDto selectProductByCode(String code){
		String sql = "select * from product where code=?";
		ProductDto pDto = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if(rs.next()){
					pDto = new ProductDto();
					pDto.setCode(rs.getInt("code"));
					pDto.setName(rs.getString("name"));
					pDto.setPrice(rs.getInt("price"));
					pDto.setProduct_img(rs.getString("product_img"));
					pDto.setProduct_img_orn(rs.getString("product_img_orn"));
					pDto.setDescription(rs.getString("description"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pDto;
	}
	
	public void updateProduct(ProductDto pDto){
		String sql = "update product set name=?, price=?, product_img=?, product_img_orn=?, description=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pDto.getName());
			pstmt.setInt(2, pDto.getPrice());
			pstmt.setString(3, pDto.getProduct_img() );
			pstmt.setString(4, pDto.getProduct_img_orn());
			pstmt.setString(5, pDto.getDescription());
			pstmt.setInt(6, pDto.getCode());
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteProduct(String code) {
		String sql="delete product where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
