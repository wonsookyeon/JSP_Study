package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardDAO;

public class BoarDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteBoard(num);
		
		String url = "BoardServlet?command=board_list";
		response.sendRedirect(url);
		
	}

}
