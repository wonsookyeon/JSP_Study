package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dto.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "product/productWrite.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext(); //환경설정 정보
		String path = context.getRealPath("upload");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024; // 업로드 파일 크기 최대 20MB로 제한
		
		MultipartRequest multi = new MultipartRequest(
				request, path, sizeLimit, encType, new DefaultFileRenamePolicy()
				);
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("description");
		
//		System.out.println("name : "+name);
//		System.out.println("price : "+price);
//		System.out.println("pictureUrl : "+pictureUrl);
//		System.out.println("description : "+description);
//		System.out.println("path : "+path);
		
		ProductVO vo = new ProductVO();
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureUrl(pictureUrl);
		vo.setDescription(description);
		
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.InsertProduct(vo); //result 가 1값이면 저장완료, -1은 저장실패
		
		if(result == 1) {
			response.sendRedirect("productList.do");
		}
		
		
		
	}
}
