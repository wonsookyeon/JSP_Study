package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ezen.vo.MemberVO;

import util.DBManager;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getinstance() {
		return instance;
	}

	public int userCheck(String id, String pass) {
		
		int result = -1;
		String sql = "select pass from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String getpass = rs.getString("pass");
				
				if(getpass != null && getpass.equals(pass)) {
					result = 1; // 아이디, 비번 일치
				}else {
					result = 0; // id = 일치, pass = 불일치
				}
			}else {
				result = -1; // 존재하지 않는 아이디
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public MemberVO getMember(String id) {
		
		MemberVO vo = null;
		
		String sql = "select * from member where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setInsertdate(rs.getTimestamp("insertdate"));
				vo.setAdmin(rs.getString("admin"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}

	public int insertMember(MemberVO vo) {
		
		int result= -1;
		String sql = "insert into member(name,id,pass,email,phone,admin) values(?, ?, ?, ?, ?, ?)";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPass());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getAdmin());
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=  null) pstmt.close();
				if(conn !=  null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int confirmID(String id) {
		int result =-1; //기본값
		String sql = "select id from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;  // 중복체크 하려는 아이디가 저장된 DB에 있으면 1
			}else {
				result = -1; // 중복체크 하려는 아이디가 저장된 DB에 없으면 -1
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=  null) rs.close();
				if(pstmt !=  null) pstmt.close();
				if(conn !=  null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updateMember(MemberVO vo) {
		
		int result = -1;
		String sql = "update member set name=?, pass=?, email=?, phone=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int deleteMember(String id) {
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where id=?";
	
		try {			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
