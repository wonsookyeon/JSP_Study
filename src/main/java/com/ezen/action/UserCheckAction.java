package com.ezen.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;


public class UserCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "login/login.jsp";
		String id= request.getParameter("id");
		String pass= request.getParameter("pass");

		
		MemberDAO mDao = MemberDAO.getinstance();
		int result = mDao.userCheck(id,pass);

		if(id == null) {
			request.setAttribute("message", " ");
			
		}else if(result == 1) {
			
			MemberVO mVo= mDao.getMember(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			
			url = "main/main.jsp";
			
		}else if (result == 0) {
			// 비번이 틀렸을 때 id값은 그대로 남아있게 하기
			request.setAttribute("id", id);
			request.setAttribute("message", "비번이 불일치합니다.");
			
		}else{
			request.setAttribute("message", "존재하지 않는 아이디 입니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
