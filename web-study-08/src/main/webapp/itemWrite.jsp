<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet res = null;
	                              //127.0.0.1
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pwd = "tiger";
	String sql = "select * from item";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 입력 완료된 정보</h2>
	
	<table border='1'>
		<tr>
			<th>상품제목</th>
			<th>가격</th>
			<th>상품설명</th>
		</tr>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver"); //jdbc 드라이버 로드
		conn = DriverManager.getConnection(url, uid, pwd); //데이터연결
		stmt = conn.createStatement();
		res = stmt.executeQuery(sql); // 결과물을 가져옴

		while(res.next()){
			out.println("<tr>");
			out.println("<td>" + res.getString("name")+"</td>");
			out.println("<td>" + res.getString("price")+"</td>");
			out.println("<td>" + res.getString("description")+"</td>");
			out.println("</tr>");
		}
		
	%>
	</table> <br>
	
	<a href="itemWriteForm.jsp">돌아가기</a>

</body>
</html>