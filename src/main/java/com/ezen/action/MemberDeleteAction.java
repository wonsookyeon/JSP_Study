package com.ezen.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;



public class MemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		MemberDAO mDao = MemberDAO.getinstance();
		mDao.deleteMember(id);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String url = "main?command=login";
		response.sendRedirect(url);
		
		
	}

}