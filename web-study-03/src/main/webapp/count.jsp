<%-- 선언문에 선언한 변수와 스크립트릿 변수의 성격 파악하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int global_cnt = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int local_cnt = 0;
	
		out.print("<br> local_cnt : ");
		out.print(++local_cnt); // 스크립트릿 태그에 선언한 변수 local_cnt는 새로고침 하면 그대로 1만 출력
		
		out.print("<br> global_cnt : ");
		out.print(++global_cnt);  // 선언문에 선언한 변수 global_cnt는 새로고침 하면 +1이 되어 출력
		
	%>

</body>
</html>