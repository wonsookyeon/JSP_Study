package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductVO> vo = pDao.selectAllProducts(); // DB product 테이블의 모든 데이터 가져오기
		
		request.setAttribute("productList", vo);
		
		String url = "product/productList.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

/*
 * 1. 상품등록 클릭
 * 2. get 서블릿 이동 - 포워드 방식으로 등록화면 전달
 * 3. 등록화면에서 등록한 후 전송버튼 클릭 - post 방식으로 서블릿 전송
 * 4. 서블릿 post 메소드에서 vo 생성 후 등록화면 - 등록한 정보를 vo 에 저장
 * 5. DAO 클래스에 insert 메소드 호출하면서 vo 전달
 * 6. insert 메소드 내에서 db랑 연결해서 vo값 저장
 * 7. 저장 여부를 insert메소드에 전달
 */



