<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="mypage/css/memberDelete.css">
<title>회원 탈퇴</title>
<script type="text/javascript" src="mypage/script/mypage1.js"></script>
</head>
<body>
<%@ include file="../header/header.jsp" %>

 
	<div id="top" align="center">	 
	   
	    <div id="join_layout">
	    
		    <div class="category">
		        <ul>
		            <li><a href="main?command=main">Home&nbsp;</a></li>
		            <li><a href="main?command=pass_check_form">▶ 마이페이지&nbsp;</a></li>
		            <li>▶ 회원 탈퇴</li>
		        </ul>
		    </div>
		    
		    <div class="join_title">
			    <h3>회원 탈퇴</h3>
		    </div>
		    
		    
			<form class="delete_form" action="main?command=member_delete" method="post" name="frm">
				<br><p><strong>${loginUser.id}님 회원 탈퇴를 원하십니까?</strong></p>
				<input type="hidden" name="command" value="pass_check">
        			 <input type="hidden" name="id" value="${loginUser.id}">
        			 <input type="hidden" name="pass" value="${loginUser.pass}">
				
				<div class="delete_form_div">
					<br><strong>비밀번호를 입력하세요.</strong><br>
					<input class="delete_pass" type="password" name="pass_check" >
					<input class="OKbnt" type="submit" value="확인" onclick="return deleteCheck()">
				</div>
			</form>
	
	
	
		</div>
	</div>

</body>
</html>