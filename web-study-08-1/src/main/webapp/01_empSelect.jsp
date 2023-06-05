<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%!
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";

	String sql = "select*from emp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	try {
		
	Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이브 로드
	conn = DriverManager.getConnection(url, uid, pass); //DB연결
	pstm = conn.prepareStatement(sql); // DB sql 문장 쓰기  - select * from emp
	rs = pstm.executeQuery(sql); // DB sql 문장 실행, 실행 결과를 rs가 참조

		while (rs.next()) {
			out.println(rs.getInt("empno"));
			out.println(rs.getString("ename"));
			out.println(rs.getString("job"));
			out.println(rs.getInt("mgr"));
			out.println(rs.getString("hiredate"));
			out.println(rs.getString("sal"));
			out.println(rs.getString("comm"));
			out.println(rs.getString("deptno"));
			out.println("<br>");
		}
	} //예외처리
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(rs != null) rs.close();
			if(pstm != null) pstm.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	%>

</body>
</html>