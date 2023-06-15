package com.saeyan.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class MovieDAO {
	
	private static MovieDAO instance = new MovieDAO();
	
	private MovieDAO() {}
	
	public static MovieDAO getInstance() {
		return instance;
	}

	public List<MovieVO> selectAllMovies() {
		
		String sql = "select * from movie order by code desc";
		List<MovieVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//데이터가 한건이 아니기 때문에 while / "" 안에 있는 이름은 DB 안에 있는 이름
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setSynopsis(rs.getString("synopsis"));
				vo.setPoster(rs.getString("poster"));
				
				list.add(vo);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public int InsertMovie(MovieVO vo) {
		
		int result = -1;
		
		String sql = "insert into movie values (product_seq.nextval,?,?,?,?,?,?)";
		                                            //DB의 시퀀스 하나씩 증가 (DB 시퀀스 에서 확인)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getSynopsis());
			pstmt.setString(6, vo.getPoster());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}

}
