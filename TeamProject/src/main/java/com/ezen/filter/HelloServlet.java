package com.ezen.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.PageController;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/main")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpServletRequest request =  (HttpServletRequest) req;
		HttpServletResponse response =  (HttpServletResponse) resp;

		System.out.println("URI path 전체보기");
		System.out.println("Context path : " + request.getContextPath());
		System.out.println("URI : " + request.getRequestURI());
		System.out.println("URL : " + request.getRequestURL());
		System.out.println("-----------------------------------------------");

		//URI만 파싱
		String endPoint = request.getRequestURI().replaceAll(request.getContextPath(),"" );
		System.out.println("endPoint : " + endPoint);
		
		PageController pagecontroller = new PageController();
		
		
		
		response.setContentType("text/html");
		//		String url = "main/main.jsp";
		//	//	url = "DBTest.jsp";
		//		RequestDispatcher dis = request.getRequestDispatcher(url);
		//		dis.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
