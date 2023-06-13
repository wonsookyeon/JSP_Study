<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB 연동</title>
</head>
<body>

 <h4>DB 연동</h4>
 
	 <%
		 Context initContext = new InitialContext();
		 Context envContext  = (Context)initContext.lookup("java:/comp/env");
		 DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		 Connection conn = ds.getConnection();
		 out.println("DBCP 연동 성공");
	 %>

</body>
</html>