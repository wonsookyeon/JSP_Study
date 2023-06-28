<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="product/css/style.css">


<title>전체 상품</title>
</head>
<body>
<div align="center">
    <div class="category">
        <ul><br>
         <li>&nbsp;&nbsp; HOME </li>
         <li> > 상품 </li>
         <li> > 전체 상품 &nbsp;&nbsp;</li>
        </ul>
    </div>
	<div class="productlist_top"><strong>상품 리스트</strong></div><br><br><br>
	<div class="container">
        <c:forEach var="productList" items="${productList}">
            <div class="item">
	            <img class="product_img" src="${productList.image}">
	            <a href="main?command=product_view&num=${productList.code}"><span>${productList.name}</span></a><br><br>
	            <span class="sale_price"><fmt:formatNumber value="${productList.price}" type="currency"/></span>
            </div>
   		</c:forEach>
	</div>
	<div class="item_page">
	</div>
</div>
</body>
</html>
