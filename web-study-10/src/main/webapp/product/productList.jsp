<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
   <div id="wrap" align="center">
      <h1>상품리스트 - 관리자 페이지</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border;white; text-align:right">
               <a href="productWrite.do">상품 등록</a>
            </td>
         </tr>
         
         <tr>
            <th>번호</th>
            <th>이름</th>
            <th>가격</th>
            <th>수정</th>
            <th>삭제</th>
         </tr>
         
         <c:forEach var="product" items="${productList}">
            <tr class="recode">
               <td>${product.code}</td>  <%-- VO에 있는 이름과 같아야함. --%>
               <td>${product.name}</td>
               <td>
               		<fmt:formatNumber value="${product.price}" pattern="#,#00원"></fmt:formatNumber>
<%--               	<fmt:formatNumber value="${product.price}" type="number"></fmt:formatNumber>원--%> 
               </td>
               <td>
                  <a href="productUpdate.do?code=${product.code}">상품 수정</a>
               </td>
               <td>
                  <a href="productDelete.do?code=${product.code}">상품 삭제</a>
               </td>
            </tr>
         </c:forEach>
      </table>
   </div>
</body>
</html>