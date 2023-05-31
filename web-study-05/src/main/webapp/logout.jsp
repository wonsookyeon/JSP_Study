<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%
	Cookie c = new Cookie("username", "");
	//2. 속성 부여 (유효기간 설정-1년)
	c.setMaxAge(0);
	//3. 클라이언트에 전송
	response.addCookie(c);
	%>
	<script>
		alert("로그아웃 되었습니다.");
		location.href="loginForm.jsp";
	</script>

</body>
</html>