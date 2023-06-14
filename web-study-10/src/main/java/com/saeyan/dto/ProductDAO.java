package com.saeyan.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//DB product 테이블의 모든 데이터 리스트에 담아서 가져오기
	public List<ProductVO> selectAllProducts(){
		
		String sql = "select * from product order by code desc";
		List<ProductVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//데이터가 한건이 아니기 때문에 while / "" 안에 있는 이름은 DB 안에 있는 이름
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPictureUrl(rs.getString("pictureurl"));
				vo.setDescription(rs.getString("description"));
				
				list.add(vo);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
		
	}

	public int InsertProduct(ProductVO vo) {
		int result = -1;
		
		String sql = "insert into product values (product_seq.nextval,?,?,?,?)";
		                                            //DB의 시퀀스 하나씩 증가 (DB 시퀀스 에서 확인)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getPictureUrl());
			pstmt.setString(4, vo.getDescription());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
		
		
		
		
	}

	public ProductVO getList(int code) {
		
		String sql = "select * from product where code = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductVO vo = new ProductVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPictureUrl(rs.getString("pictureurl"));
				vo.setDescription(rs.getString("description"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}

	public int UpdateProduct(ProductVO vo) {
		int result = -1;
		
		String sql = "update product set name=?, price=?, pictureUrl=?, description=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getPictureUrl());
			pstmt.setString(4, vo.getDescription());
			pstmt.setInt(5, vo.getCode());
			
			result=pstmt.executeUpdate();
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int productDelete(int code) {
		int result = -1;
		
		String sql = "delete product where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			result=pstmt.executeUpdate();
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
}