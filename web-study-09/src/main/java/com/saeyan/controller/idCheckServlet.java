package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;

@WebServlet("/idCheck.do")
public class idCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//회원가입에서 아이디를 입력하였을때 그 아이디 값을 가져옴
		String userid = request.getParameter("userid");
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.confirmID(userid); //MemberDAO에 추가
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		//아이디 중복체크하는 idcheck.jsp 실행
		RequestDispatcher dis = request.getRequestDispatcher("idCheck.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
