package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(description = "처음 만드는 서블릿", urlPatterns = { "/HelloWorldServlet" })
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 콘텐츠 타입 설정 및 한글 설정
		response.setContentType("text/html;charset=UTF-8");
		
		// 웹브라우저 출력을 위한 PrintWriter 객체 확보
		PrintWriter out = response.getWriter();
		
		// HTML형식으로 브라우저 출력 콘텐츠 작성
		out.println("<html>");
		out.println("<head><title>Hello World Servlet</title></head>");
		out.println("<body><h2>Hello World Servlet : 헬로월드</h2></body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post 에서 별다른 처리 없이 doGet으로 포워딩
		doGet(request, response);
	}

}
