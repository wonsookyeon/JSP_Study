package com.ezen.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;



public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		
		MemberDAO mDao = MemberDAO.getinstance();
		
		int result = mDao.confirmID(id); //MemberDAO에 추가
		
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		//아이디 중복체크하는 idcheck.jsp 실행
		String url = "join/idCheck.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}

}
