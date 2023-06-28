<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
// html dom 이 다 로딩된 후 실행된다.
$(document).ready(function(){
    // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
    $(".menu>a").click(function(){
        var submenu = $(this).next("ul");

        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
});
</script>
<meta charset="UTF-8">
<link rel="stylesheet" href="FAQ/css/style.css">
<title>FAQ</title>
</head>
<body>
	<div></div>

	<div id="wapper">

		<div id="main-body">
			<!--네비게이션-->
			<nav>
				<h1>고객센터</h1>
				<br />
				<ul>
					<li><a href="">FAQ</a></li>
					<br />
					<li><a href="">공지사항</a></li>
					<br />
					<li><a href="">매장안내</a></li>
					<br />
					<li><a href="">1:1문의하기</a></li>
					<br>
					<li><h1>080-012-7878</h1></li>
					<br />
					<li style="font-size: 14px">AM 09:00 - PM 17:00 <br>(점심시간
						11:30 - 12:30) DAY OFF (토/일/공휴일 휴무)
					</li>
					<br />
					<li><input class="support" type="button" value="1:1문의하기"></li>
				</ul>
			</nav>
			<!--콘텐츠부분-->
			<section>
				<!--<p>FAQ</p>-->
				<article>
					<c:forEach var="faq" items="${FAQList}">
						<div>
							<ul>
								<li class="menu">
									<a><strong>${faq.subject}</strong></a>
										<ul class="hide"> <br>
											<li>${faq.content}</li> <br/>
										</ul>						
								</li><hr/>
							</ul>
						
						
						<!--  <ul id="subject" style="font-size: 18px; font-style: bold">
								<li><strong>${faq.subject}</strong></li>
								<li>${faq.content}</li>
								<br>
							</ul> -->
							
						</div>
					</c:forEach>
			</article>
			</section>
			
			<!--<aside>
				<p>aside</p>
			</aside>-->
		</div>
		<!--풋터-->
		<footer>footer</footer>
	</div>
</body>
</html>
