package com.saeyan.dao;
// Data Access Object
// DB데이터를 VO 객체로 얻어오거나 VO 객체에 저장된 값을 DB에 추가하기 위해
// 자바빈, 데이터 접근이 목적인 객체, 회원정보 수정, 추가, 삭제
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

// 싱글톤 패턴(메모리 낭비를 막기 위해 객체를 단 한번만 올려놓고 공유, 한 개의 인스턴스만 생성
public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {}
	
	public static MemberDAO getInstance() { //값을 read only property 로 만들기 위해서 setter X, getter만 만듬
		return instance;
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		conn = DriverManager.getConnection(url, uid, upwd);  이거 대신 ↓ getConnection()으로
	}
	// 커넥션 풀
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	
	// userid, pwd 가 DB에 있는지 여부 체크
	//사용자 인증시 사용하는 메소드
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
	
	// 로그인 했을때 아이디로 회원정보를 모두 가져오는 메소드	
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

	// 매개변수로 받은 VO객체 아이디로 member 테이블에서 검색해서
	// VO 객체에 저장된 정보로 회원정보를 수정
	public int updateMember(MemberVO vo) {
		
		int result = -1;
		String sql = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
			pstmt.setInt(4, vo.getAdmin());
			pstmt.setString(5, vo.getUserid());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 중복체크하려는 DB안의 아이디 값을 가져옴
	// 회원 가입시 아이디 중복을 확인
	public int confirmID(String userid) {
		int result =-1; //기본값
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
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

	// 매개변수로 받은 VO 객체를 member DB 테이블에 삽입
	public int insertMember(MemberVO vo) {
		int result= -1;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
//		String sql = "insert into member(name, userid, pwd, email, phone, admin) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
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
}
