<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="header/css/style.css">

<ul class="top">
	<c:choose>
		<c:when test="${loginUser.name != null}">
		<span>${loginUser.name}님 환영합니다.</span>
		<a href="main?command=userLogout">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="main?command=userLogin">로그인</a>	
			<a href="main?command=join_form">회원가입</a>
		</c:otherwise>
	</c:choose>
	
	<a href="main?command=pass_check_form">마이페이지</a>
	<a href="membership.jsp">멤버십</a>
	<a href="help.jsp">고객센터</a>
	<select name="Lauguage">
		<option>KOREAN</option>
		<option>ENGLISH</option>
	</select>
</ul>

<ul class="logo">
	<li id="logo"><a href="main?command=main"> <img
			src="https://cdn3-aka.makeshop.co.kr/design/skinfood/skinfood/images/design/logo.png">
	</a></li>
</ul>
<ul class="menu">
	<li><a href="main?command=product_list"><strong>상품</strong></a>
		<ul class="submenu">
			<li><a href="#">신상품</a></li>
			<br>
			<li><a href="#">베스트 상품</a></li>
			<br>
			<li><a href="#">라인별</a></li>
			<br>
			<li><a href="#">타입별</a></li>
			<br>
			<li><a href="#">유형별</a></li>
			<br>
		</ul></li>
	<li><a href="#"><strong>이벤트</strong></a>
		<ul class="submenu">
			<li><a href="#">진행중 이벤트</a></li>
			<br>
			<li><a href="#">종료된 이벤트</a></li>

		</ul></li>
	<li><a href="main?command=review"><strong>리뷰</strong></a>
		<ul class="submenu">
			<li><a href="main?command=review">리뷰</a></li>
			<br>
		</ul></li>
	<li><a href="main?command=faq"><strong>커뮤니티</strong></a>
		<ul class="submenu">
			<li><a href="main?command=faq">FAQ</a></li>
			<br>
			<li><a href="main?command=location">매장안내</a></li>
			<br>
			<li><a href="main?command=contact">1:1문의하기</a></li>
		</ul></li>

	<!-- 아이콘 -->
	<li class="img_icon" style="margin-right: 0px;"><a href="#"><img
			src="https://www.theskinfood.com/design/skinfood/skinfood/images/icon/icon-search.svg"
			width=30px; height=30px></a></li>
	<li><a href="#"><img
			src="https://www.theskinfood.com/design/skinfood/skinfood/images/icon/icon-cart.svg"
			width=30px; height=30px></a></li>
</ul>


