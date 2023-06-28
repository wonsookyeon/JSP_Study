package com.ezen.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;

public class MemberUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		MemberDAO mDao = MemberDAO.getinstance();  //DB 연결
		
		MemberVO vo = mDao.getMember(id); //모든정보를 vo에 담음
		System.out.println(vo);
		request.setAttribute("mVo", vo);
		String url = "mypage/mypage.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
