<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="mypage/css/passCheck.css">
<title>패스워드 재확인</title>
</head>
<body>
<%@ include file="../header/header.jsp" %>

	<div id="top" align="center" >
	    
	    <div id="passCheck_layout">
	    
		    <div class="category">
		        <ul>
		            <li><a href="main?command=main">Home&nbsp;</a></li>
		            <li>▶ 마이페이지 ▶</li>
		            <li>&nbsp;비밀번호 재확인</li>
		        </ul>
		    </div>
		    
		    
		    <div class="passCheck_title">
		    	<h1>비밀번호 재확인</h1>
		    </div>
		    
		    <div class="passCheck">
		    
		    	<div>
		    		<img src="mypage/img/잠금.jpg">
		    		<p>
		    			저희 쇼핑몰에서는 회원님의 소중한 개인정보를 안전하게 보호하고<br>
						개인정보 도용으로 인한 피해를 예방하기 위하여 비밀번호를 확인합니다.<br>
						비밀번호는 타인에게 노출되지 않도록 주의해주세요.
		    		</p>
		    	</div>
		    	
		    
		    	<form action="main?command=pass_check" name="frm" method="post">
         			 <input type="hidden" name="command" value="pass_check">
        			 <input type="hidden" name="id" value="${loginUser.id}">
       			 
        			 <div class="frm">
        			 <table>
	        			 	<tr>
	        			 		<td>
	        			 			<span>ID</span>
	        			 		</td>
	        			 		<th>
	        			 			<strong>${loginUser.id}</strong> 
	        			 		</th>
	        			 	</tr>
	        			 	<tr>	
	        			 		<td>
	        			 			<span>PASSWORD</span>
	        			 		</td>
	        			 		<th>
	        			 			<input type="password" name="pass"
	        			 			placeholder=" 비밀번호를 입력하세요." value="${pass}">
	        			 		</th>
	        			 	</tr>
        			 </table>
        			 </div>
        			 
        			 <div class="message">
        			 	${message}<br>
        			 	<div class="bnt">	
        			 		<input type="submit" value="확인">
        				</div>
        			</div>
		    		
		    	
		    	
		    	</form>
		    	
		    	
		    	
		    	
		    </div>
		    
		    
		</div>
	</div>



<%@ include file="../footer/footer.jsp" %>

</body>
</html>
