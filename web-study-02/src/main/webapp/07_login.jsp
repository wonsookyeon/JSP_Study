<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="login.js"></script>
</head>

<body>

	<form name="frm" method="get" action="LoginServlet">
		<label for="userid"> <!-- 글씨 클릭하면 커서 생기게 해주는 코드 input 안에 id = "userid" 랑 짝꿍-->
		아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	
	<label for="userpwd">암 &nbsp; 호 : </label>
	<input type="password" name="pwd" id="userpwd"><br>
	
	<input type="submit" value="로그인" onclick = "return check()">
	</form>

</body>
</html>