<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>

<body>
<!-- 저장한 배열을 c:forEach 태그의 varStatus 속성을 사용하여 인덱스와 반복횟수 출력 -->

	<%
	String[] movieList ={ "타이타닉", "시네마 천국", "혹성 탈출", "킹콩" };
	pageContext.setAttribute("movieList", movieList);
	%>
	
	<table border="1" style="width=100%; text-align:center;">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
		
		<c:forEach var="movie" items="${movieList}" varStatus="status">
		<tr>
			<td> ${status.index} </td>
			<td> ${status.count} </td>
			<td> ${movie} </td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>