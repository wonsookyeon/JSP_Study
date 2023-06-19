//게시글을 데이터베이스에 수정하기 위한 액션 클래스
package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BoardVO vo = new BoardVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.updateBoard(vo);
		
		String  url = "BoardServlet?command=board_list";
		response.sendRedirect(url);
		
//		new BoardListAction().execute(request, response);
		
		
	}

}
