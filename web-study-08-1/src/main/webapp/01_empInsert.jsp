<%-- 사이트의 formtag에서 입력해서 insert 하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upwd = "tiger";
	String sql = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%	
	
		request.setCharacterEncoding("utf-8");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이브 로드
			conn = DriverManager.getConnection(url, uid, upwd); //DB연결
			pstmt = conn.prepareStatement(sql); // DB sql 문장 쓰기  - select * from emp

			pstmt.setInt(1, Integer.parseInt(request.getParameter("empno")));  // 위에서 String 으로 받아주었으므로 Integer형으로 바꿔줘야 한다.
			pstmt.setString(2, request.getParameter("ename"));
			pstmt.setString(3, request.getParameter("job"));
			pstmt.setInt(4, Integer.parseInt(request.getParameter("mgr")));
			pstmt.setString(5, request.getParameter("hiredate"));
			pstmt.setInt(6, Integer.parseInt(request.getParameter("sal")));
			pstmt.setInt(7, Integer.parseInt(request.getParameter("comm")));
			pstmt.setInt(8, Integer.parseInt(request.getParameter("deptno")));
			
			int result = pstmt.executeUpdate();
		 	System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
	<h3>입력성공</h3>
	<a href="01_empSelect.jsp">결과 보기</a>
<%--
	<%
		request.setCharacterEncoding("utf-8");
		
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String hirdate = request.getParameter("hirdate");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =  DriverManager.getConnection(url,uid,upwd);
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(empno));
			psmt.setString(2, ename);
			psmt.setString(3, job);
			psmt.setInt(4, Integer.parseInt(mgr));
			psmt.setDate(5, Date.valueOf(hirdate));
			psmt.setString(6, sal);
			psmt.setString(7, comm);
			psmt.setString(8, deptno);
			
			psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
	<a href="01_empSelect.jsp">결과 보기</a>
 --%>
</body>
</html>