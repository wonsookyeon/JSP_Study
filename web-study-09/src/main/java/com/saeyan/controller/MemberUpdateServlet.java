//회원정보변경 버튼 누르면 연결되는 서블릿
package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDAO mDao = MemberDAO.getInstance();  //DB 연결
		MemberVO vo = mDao.getMember(userid); //소미의 모든정보를 vo에 담음
		request.setAttribute("mVo", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("memberUpdate.jsp");
		dis.forward(request, response);
	
	}
//회원정보 수정에서 확인 눌렀을 때 받아주는 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글깨지지않게
		
		String userid= request.getParameter("userid");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		//클래스에 담아주기
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setAdmin(Integer.parseInt(admin));
		
		//DB 연결
		MemberDAO mDao = MemberDAO.getInstance();//객체생성
		mDao.updateMember(vo);  //MemberDAO 파일에 생성
		response.sendRedirect("login.do");
		
	}

}
