<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pwd = "tiger";
	String sql = "select * from member";
	//값 추가하기
//	String sql = "insert into member values('강현승', 'liver','1234','liver@naver.com','010-1111-2222', 0)";

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc 드라이버 로드
		conn = DriverManager.getConnection(url,uid,pwd); // 연결
		System.out.println(conn); // 연결된 주소값
		stmt = conn.createStatement(); //connection 객체로부터 Statement 객체를 얻어옴
		rs = stmt.executeQuery(sql); //결과값을 가져옴
//		int num = stmt.executeUpdate(sql);
		
		while(rs.next()){ // rs에 데이터가 있으면 true, 없으면 false
			out.println(rs.getString("name")); // 테이블 네임과 일치해야 한다.
			//out.println(rs.getString(1)); // 이렇게해도 name과 같게 나오긴 하지만 하지마렴
			out.println(rs.getString("userid"));
			out.println(rs.getString("pwd"));
			out.println(rs.getString("email"));
			out.println(rs.getString("phone"));
			out.println(rs.getInt("admin")+"<br>");
		}
//		out.println("num : " + num);
		
		out.println("출력 완료");
	%>

</body>
</html>