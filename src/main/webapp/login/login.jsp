<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="login/css/login.css">
<script type="text/javascript" src="login/script/login.js"></script>
</head>
<body>

	<div id="login_header">
        <div class="backbnt">
        	<a href="main?command=main"> ◀◀뒤로가기 </a>
        </div>
        <div class="shopName">
        	<a href="main?command=login">SKINFOOD</a>
        </div>
    </div>

    <div id="login_section">
        <div class="content">
            <h3 class="title">로그인</h3>
        	<div class="loginimg"><img src="login/img/스킨푸드.png"></div>
            
            <form name="frm" method ="post" action="main?command=login">
                <div id="memberLogin">
                	<div class="loginmessage">${message}</div>
                    <div class="inputBox">
                        <input type="text" name="id" placeholder="아이디" value="${id}" > <br>
                        <input type="password" name="pass" placeholder="비밀번호" value="${pass}">
                    </div>
                    
                    <div class="loginCheckBox">
                        <input type="checkbox" name="save_id" id="save_id" value="on">
                        <label for="save_id">아이디저장</label>
                    </div><br>
                    
                    <div class="loginBtn">
                        <input type="submit" value="로그인" onclick="return loginCheck()">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="button" value="가입하기"
                        onclick="location.href='main?command=join_form'">
                    </div>
                </div>
            </form>
            
        </div>
    </div>
	

</body>
</html>
