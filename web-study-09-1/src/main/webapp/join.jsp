<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>

	<h2>회원 가입</h2>
	'*' 표시항목은 필수 입력 항목입니다.
	<form action="join.do"  method="post" name="frm" >
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="이름" size=20></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="아이디" size=20 id="userid">
				<input type="text" name="reid" size=20>
				<input type="text" value="중복체크" onclick="idCheck()">
				</td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="암호" size=20>*</td>
			</tr>
			<tr>
				<td>암호 확인</td>
				<td><input type="password" name="암호확인" size=20>*</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="이메일" size=20></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="전화번호" size=20></td>
			</tr>
			<tr>
				<td>등 급</td>
				<td>
					<input type="radio" name="등급" value="0" checked="checked">일반회원
					<input type="radio" name="등급" value="1">관리자
				</td>
			</tr>
		</table>	
	</form>

</body>
</html>