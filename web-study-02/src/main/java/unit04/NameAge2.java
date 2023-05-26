package unit04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/name")
public class NameAge2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
				
//		System.out.println(name);
//		System.out.println(age);
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		RequestDispatcher dis = request.getRequestDispatcher("namemethod.jsp");
		dis.forward(request, response);
		
		
//		String name = "홍길동";
//		int age = 10;
//		
//		request.setAttribute("name", name);
//		request.setAttribute("age", age);
//		
//		RequestDispatcher dis = request.getRequestDispatcher("namemethod.jsp");
//		dis.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
