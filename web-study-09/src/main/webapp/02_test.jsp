<%-- MemberDAO 커넥션 객체를 얻어내는지 확인하기 위한 test --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.saeyan.dao.MemberDAO" %>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDAO memDao = MemberDAO.getInstance();
		//MemberDAO memDao = new MemberDAO(); 는 불가 : private 로 묶여있기 때문에 import해서 연결해주고 가져와야 한다.
		Connection conn= memDao.getConnection();
		out.println("DBCP 연결 성공!!");
	%>

</body>
</html>