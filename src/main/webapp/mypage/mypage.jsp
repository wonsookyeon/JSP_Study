<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="mypage/css/mypage.css">
<title>회원 가입/수정</title>

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
		            <li>▶ 회원정보 입력</li>
		        </ul>
		    </div>
		    
		    <div class="join_title">
			    <h3>회원정보 입력</h3>
		    </div>
		    
		    <form action="main?command=member_update" method="post" name="frm" >
		    <input type="hidden" name="command" value="member_update">
		    <input type="hidden" name="id" value="${mVo.id}">
				<div id=member_info>
					<table class="member_table">
						<colgroup>
							<col style="width: 155px">
						</colgroup>
						
						<tr>
							<th>
								<div class="head_cell">
									<span>*</span>이름
								</div>
							</th>
							<td>
								<div class="info_cell">
									<input style="width: 280px" type="text" name="name" value="${mVo.name}" size="15">
								</div>
							</td>
						</tr>
						
						<tr>
							<th>
								<div class="head_cell">
									<span>*</span>아이디
								</div>
							</th>
							<td>
								<div class="info_cell">
									<input style="width: 160px" type="text" name="id"
									value="${mVo.id}" size="10" readonly="readonly">
								</div>
							</td>
						</tr>
						
						<tr>
							<th>
								<div class="head_cell">
									<span>*</span>신규비밀번호
								</div>
							</th>
							<td>
								<div class="info_cell">
									<input type="password" name="pass" value="${mVo.pass}" size="15">
									<span class="pw_info">
										<br>* 영문 대소문자/숫자/특수문자를 혼용하여 2종류 10~16자 또는 3종류 8~16자
									</span>
								</div>
							</td>
						</tr>
						
						<tr>
							<th>
								<div class="head_cell">
									<span>*</span>신규비밀번호 확인
								</div>
							</th>
							<td>
								<div class="info_cell">
									<input type="password" name="pass_check" size="15">
								</div>
							</td>
						</tr>
						
						<tr>
							<th>
								<div class="head_cell">
									<span>*</span>이메일
								</div>
							</th>
							<td>
								<div class="info_cell">
									<input style="width: 280px" type="email" name="email" value="${mVo.email}" size="20">
								</div>
							</td>
						</tr>
						
						<tr>
							<th>
								<div class="head_cell">
									<span>*</span>휴대폰
								</div>
							</th>
							<td>
								<div class="info_cell">
									<input style="width: 280px" type="text" name="phone" value="${mVo.phone}" size="15">
								</div>
							</td>
						</tr>
						
						
						
					</table>
				</div>
  				<!-- addInfo 
				<div class="addInfo">
					<table>
						<tr>
							<th>
								<div class="head_cell">피부타입</div>
							</th>
							<th>
								<div class="info_cell">
									<label>
										<input type="radio">건성
									</label>
								</div>
							</th>
							
						</tr>
					</table>
				</div>
-->				
				
				<div class="bnt">
					<div class="update_bnt">
						<input type="submit" value="수정하기" onclick="return updateCheck()">
					</div>	
					<div class="reset_bnt">
						<input type="reset" value="취소하기">
					</div>
					<div class="bye_bnt">
						<input type="button" value="탈퇴하기"
						onclick="location.href='main?command=member_delete_pass_form'">
					</div>	
				</div>
				
				
			</form>

		    
		</div>
<%@ include file="../footer/footer.jsp" %>
		
	</div>
		

</body>
</html>
