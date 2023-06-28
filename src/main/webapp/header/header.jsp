<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="header/css/style.css">
<title>스킨푸드</title>
</head>
<header>
	<ul class="top">
		<a href="login.jsp">로그인</a>
		<a href="join.jsp">회원가입</a>
		<a href="main?command=pass_check_form">마이페이지</a>
		<a href="membership.jsp">멤버십</a>
		<a href="help.jsp">고객센터</a>
		<select name="Lauguage">
			<option>KOREAN</option>
			<option>ENGLISH</option>
		</select>
	</ul>
</header>
<body>
	<ul class="logo">
		<li id="logo">
			<a href="main.jsp"> 
				<img src="https://cdn3-aka.makeshop.co.kr/design/skinfood/skinfood/images/design/logo.png">
			</a>
		</li>
	</ul>
	<ul class="menu">
		<li><a href="#"><strong>상품</strong></a>
			<ul class="submenu">
				<li><a href="#">신상품</a></li>
				<li><a href="#">베스트 상품</a></li>
				<li><a href="#">라인별</a></li>
				<li><a href="#">타입별</a></li>
				<li><a href="#">유형별</a></li>
			</ul></li>
		<li><a href="#"><strong>이벤트</strong></a>
			<ul class="submenu">
				<li><a href="#">진행중 이벤트</a></li>
				<li><a href="#">종료된 이벤트</a></li>
				<li><a href="#"> </a></li>
				<li><a href="#"> </a></li>
				<li><a href="#"> </a></li>
			</ul></li>
		<li><a href="#"><strong>리뷰</strong></a>
			<ul class="submenu">
				<li><a href="#">리뷰</a></li>
			</ul></li>
		<li><a href="#"><strong>커뮤니티</strong></a>
			<ul class="submenu">
				<li><a href="#">멤버쉽</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">매장안내</a></li>
				<li><a href="#">1:1문의하기</a></li>
			</ul></li>
	</ul>
	<ul class="icon">
		<li id="search_img">
			<a href="search.jsp">
				<img src="https://www.theskinfood.com/design/skinfood/skinfood/images/icon/icon-search.svg">
			</a>
		</li>
		<li id="basket_img">
			<a href="backet.jsp">
				<img src="https://www.theskinfood.com/design/skinfood/skinfood/images/icon/icon-cart.svg">
			</a>
		</li>
	</ul>
</body>
</html>
