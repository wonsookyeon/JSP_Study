package com.ezen.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;



public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //한글깨지지않게
		
		String id= request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		
		//클래스에 담아주기
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPass(pass);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		
		//DB 연결
		MemberDAO mDao = MemberDAO.getinstance();//객체생성
		mDao.updateMember(vo);  //MemberDAO 파일에 생성
		
		String url="main?command=pass_check_form";
		response.sendRedirect(url);

	}

}
