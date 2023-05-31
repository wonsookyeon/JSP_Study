<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = "test";
String pwd = "1234";
String name = "원숙연";

if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ){
	session.setAttribute("loginUser", name);
	response.sendRedirect("10_1_main.jsp");
	}
	else{
	response.sendRedirect("10_1_loginForm.jsp");
	}
	%>