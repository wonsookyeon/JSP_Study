<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		if(window.name == "update"){
			window.opener.parent.location.href=
				"BoardServlet?command=board_update_form&num=${param.num}";
		}else if(window.name == 'delete'){ //삭제 -> 같은기능이라 하나에 모아서 함
			alert("삭제되었습니다.");
			window.opener.parent.location.href=
				"BoardServlet?command=board_delete&num=${param.num}";
		}
		
		window.close();
	</script>

</body>
</html>