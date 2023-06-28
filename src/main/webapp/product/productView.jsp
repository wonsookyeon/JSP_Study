<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div align="center">
	<div class="category">
        <ul><br>
         <li>&nbsp;&nbsp; HOME </li>
         <li> > 상품 </li>
         <li> > 상품 상세 &nbsp;&nbsp;</li>
        </ul>
    </div>
    <div class="detail_product">
    	<br><br><br>
		<table class="detail_table">
			<tr>
				<td rowspan="8"><img class="detail_img" src="${product.image}"></td>
				<td colspan="2"><h2>${product.name}</h2></td>
			</tr>
			<tr><td colspan="2"><fmt:formatNumber value="${product.price}" type="currency"/></td></tr>
			<tr>
				<td>관련태그</td>
				<td>태그나열</td>			
			</tr>
			<tr>
				<td>배송비</td>
				<td>30000원 이상 주문 시 배송비는 무료입니다.</td>			
			</tr>
			<tr>
				<td>리뷰</td>
				<td>리뷰개수</td>			
			</tr>
			<tr>
				<td colspan="2">상품이름</td>
			</tr>			
			<tr>
				<td colspan="2">상품수량고르기</td>
			</tr>	
			<tr>
				<td>합계</td>
				<td>합게금액</td>
			</tr>	
		</table>
		<div class="detail_buy">
			<div> 이미지 슬라이드 </div>
			<div>장바구니 담기</div>
			<div>구매하기</div>
		</div>
		
	</div> 
	
</div>
</body>
</html>
