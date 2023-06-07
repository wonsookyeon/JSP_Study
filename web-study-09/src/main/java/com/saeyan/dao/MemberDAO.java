package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		conn = DriverManager.getConnection(url, uid, upwd);  이거 대신 ↓ getConnection()으로
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	
	// userid, pwd 가 DB에 있는지 여부 체크
	public int userCheck(String userid,String pwd) {
		int result = -1;
		String sql = "select pwd from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DB 연결
			conn = getConnection();
			// DB 선행으로 문장 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			// 값이 pwd 하나값만 나오므로 while 문장 안씀.
			if(rs.next()) {
				String getpwd = rs.getString("pwd");
				if(getpwd != null && getpwd.equals(pwd)) {
					result = 1; // 아이디, 비번 일치
				}else {
					result = 0; // id = 일치, pwd = 불일치
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
// 로그인 했을때 전체 값이 다 나오게 하는	
	public MemberVO getMember(String userid) {
		MemberVO vo = null;
		
		String sql = "select * from member where userid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
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

}
