<%-- 프로그램에서 입력해서 직접 insert 하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
	
	String name = "숙연";
	String userid = "wsy";
	String pwd= "1234";
	String email = "sook@naver.com";
	String phone = "010-1111-1234";
	int admin = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,uid,pass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setString(2,userid);
			pstmt.setString(3,pwd);
			pstmt.setString(4,email);
			pstmt.setString(5,phone);
			pstmt.setInt(6,admin);
			
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(conn!=null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>

</body>
</html>