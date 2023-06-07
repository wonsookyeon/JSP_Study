//login 에서 넘어온 아이디, 비밀번호가 DB와 일치하는지
package com.saeyan.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "login.jsp";
		String userid= request.getParameter("userid");
		String pwd= request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);
		
		if(result == 1) {
			
			MemberVO mVo= mDao.getMember(userid);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("massage", "로그인 성공!!");
			url = "main.jsp";
		}else if (result == 0) {
			// 비번이 틀렸을 때 id값은 그대로 남아있게 하기
			request.setAttribute("userid", userid);
			
			request.setAttribute("massage", "비번이 불일치합니다.");
			
		}else {
			request.setAttribute("massage", "존재하지 않는 아이디 입니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
