<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="param.js"></script>
	<!-- javascript를 실행하려면 넣어줘야됨 -->

</head>

<body>

	<!-- submit 버튼을 클릭하면 url 주소가 Paramservlet을 get방식 찾아간다.. doGet 메소드 실행-->
	<form name="frm" method="get" action="Paramservlet">
		아이디 : <input type="text" name = "id"><br>
		나&nbsp;&nbsp;이 : <input type="text" name = age><br>
		<input type="submit" name = "전송" onclick = "return check()">
		                                  <!-- 클릭하면 javascript function check() 실행 -->
	</form>

</body>
</html>