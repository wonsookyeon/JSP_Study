package com.ezen.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ezen.dao.FaqDAO;
import com.ezen.vo.FaqVO;

public class FAQAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FaqDAO fDao = FaqDAO.getinstance();
		List<FaqVO> list = fDao.goCrawling();

		request.setAttribute("FAQList", list);

		String url  = "FAQ/faq.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
