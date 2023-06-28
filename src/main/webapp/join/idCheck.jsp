<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="join/script/join.js"></script>
</head>
<body>

	<h2>아이디 중복확인</h2>
	<form action="main?command=id_check" method="post" name="frm">
		아이디<input type="text" name="id" value="${id}" id="id">
			<input type="submit" value="중복체크">
		<br>
		
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.id.value="";
				document.getElementById("id").value=""; <%-- 중복체크 눌렀을때 뜨는 창에 입력한 id가 입력창에서 사라지게 함 --%>
			</script>
			${id}는 이미 사용중인 아이디입니다.
		</c:if>
		
		<c:if test="${result == -1}">
				${id}는 사용가능한 아이디입니다.
				<input type="button" value="사용" class="cancel", onclick="idok()">
		</c:if>
	</form>

</body>
</html>