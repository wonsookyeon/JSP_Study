package com.ezen.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;

public class UserPassCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		System.out.println("id: " + id);
		System.out.println("pass: " + pass);
		String url = null;
		
		MemberDAO mDao = MemberDAO.getinstance();
		MemberVO vo = mDao.getMember(id);

		System.out.println(vo);
		
	
		
		if(vo.getPass().equals(pass)) {
			
			request.setAttribute("mVo", vo);
			url = "mypage/mypage.jsp";
		}else {
			url = "mypage/passCheck.jsp";
			request.setAttribute("message", "비밀번호가 틀립니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
	}

}
