<%-- 프로그램에서 입력해서 직접 insert 하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%!
	Connection conn = null;
	PreparedStatement psmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upwd = "tiger";
	String sql = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
	
	int empno = 1111;
	String ename = "Roy";
	String job = "Dog";
	int mgr = 0000;
	String hiredate = "23/06/05";
	int sal = 1000;
	int comm = 100;
	int deptno = 30;
	
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
			conn = DriverManager.getConnection(url, uid, upwd); //DB연결
			psmt = conn.prepareStatement(sql); // DB sql 문장 쓰기  - select * from emp

			psmt.setInt(1, empno);
			psmt.setString(2, ename);
			psmt.setString(3, job);
			psmt.setInt(4, mgr);
			psmt.setString(5, hiredate);
			psmt.setInt(6, sal);
			psmt.setInt(7, comm);
			psmt.setInt(8, deptno);
			
			int result = psmt.executeUpdate();
		 	System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
	
	<a href="01_empSelect.jsp">결과 보기</a>

</body>
</html>