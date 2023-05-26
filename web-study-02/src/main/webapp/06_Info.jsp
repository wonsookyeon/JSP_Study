<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="info.js"></script>
</head>
<body>
	<h3> get 방식에서 한글 깨짐 방지 </h3>
	<form name="frm" method="get" action="Infoservlet">
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="addr"><br>
		<input type="submit" value="전송" onclick = "return check()">
	</form>
	
	<br>
	
	<h3> post 방식에서 한글 깨짐 방지 </h3>
	<form name="frm2" method="post" action="Infoservlet">
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="addr"><br>
		<input type="submit" value="전송" onclick = "return check2()">
	</form>
	

</body>
</html>