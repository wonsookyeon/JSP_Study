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

	<c:set var="msg" value="Hello"></c:set>
	\${msg} = ${msg}<br>
	
	<c:set var="age">
		30
	</c:set>
	\${age} = ${age}<hr>
	

	<c:set var="member" value="<%=new com.saeyan.javabeans.MemberBean()%>"></c:set>
	<c:set target="${member}" property="name" value="전수빈"></c:set>
	<c:set target="${member}" property="userid">pinksubin</c:set>
	\${member} = ${member}

	<hr>
	
	\${member.name} = ${member.name} <br>
	\${member.userid} = ${member.userid} <br>
	\${member.email} = ${member.email} <!-- jstl에서는 null값이 공백으로 나옴 -->

	<hr>

	<c:set var="add" value="${10 + 5}"></c:set>
	\${add} = ${add}<br>
	<c:set var="flag" value="${10 > 5}"></c:set>
	\${flag} = ${flag}<br>
	
	

</body>
</html>