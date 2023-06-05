<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="01_empInsert.jsp">
		<table>
			<tr>
				<td>부서번호 : </td>
				<td><input type="text" name="empno" size="20"></td>
			</tr>
			<tr>
				<td>이 &nbsp;&nbsp;&nbsp; 름 : </td>
				<td><input type="text" name="ename" size="20"></td>
			</tr>
			<tr>
				<td>직 &nbsp;&nbsp;&nbsp; 무 : </td>
				<td><input type="text" name="job" size="20"></td>
			</tr>
			<tr>
				<td>상 &nbsp;&nbsp;&nbsp; 사 : </td>
				<td><input type="text" name="mgr" size="20"></td>
			</tr>
			<tr>
				<td>입&nbsp;사&nbsp;일 : </td>
				<td><input type="text" name="hiredate" size="20"></td>
			</tr>
			<tr>
				<td>급 &nbsp;&nbsp;&nbsp; 여 : </td>
				<td><input type="text" name="sal" size="20"></td>
			</tr>
			<tr>
				<td>보&nbsp;너&nbsp;스 : </td>
				<td><input type="text" name="comm" size="20"></td>
			</tr>
			<tr>
				<td>사 &nbsp;&nbsp;&nbsp; 번 : </td>
				<td><input type="text" name="deptno" size="20"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="전송"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>