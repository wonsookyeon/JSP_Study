package com.ezen.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;

public class MemberJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAdmin(request.getParameter("admin"));
		
		//DB저장
		MemberDAO mDao = MemberDAO.getinstance();
		int result = mDao.insertMember(vo);  //DB접근
		
		//세션있으면 가져오고 아니면 만들어라
		HttpSession session = request.getSession();
		if(result == 1) { //DB에 값이 들어감
			session.setAttribute("id", vo.getId());
			request.setAttribute("message", "회원 가입 성공");
		}else {
			request.setAttribute("message", "회원 가입 실패");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("login/login.jsp");
		dis.forward(request, response);
	}

}
