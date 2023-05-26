package unit06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Infoservlet")
public class Infoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		// doGet은 응답을 해줄때 기본적으로 utf-8 이 포함되어 있으므로 안써도 됨.
		
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("당신이 입력한 정보입니다.<br>");
		out.print("이름 : ");
		out.print(name);
		out.print("<br> 주소 : ");
		out.print(addr);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//순서중요 (doPost 에서 응답해줄때 한글깨짐 방지)
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
		
	}

}
