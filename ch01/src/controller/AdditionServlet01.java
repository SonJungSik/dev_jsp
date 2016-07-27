package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NumDto;
import service.AdditionService;

/**
 * Servlet implementation class AdditionServlet01
 */

//  @WebServlet(description = "두 수의 합을 구하는 Servlet", urlPatterns = { "/as" })
//  @WebServlet("/as")  // url mapping
public class AdditionServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // serialVerwionUID → 직렬화를 위해 필요   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionServlet01() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request
					   , HttpServletResponse response)
				  throws ServletException, IOException {
//		int num1 = 20;
//		int num2 = 10;
//		int add = num1 + num2;
		
		NumDto numDto = new NumDto(20, 10);
		AdditionService as = new AdditionService(numDto);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>"
				  + numDto.getNum1() 
				  + "+" 
				  + numDto.getNum2() 
				  + " = " 
				  + as.add());
		out.println("</h1></body></html>");
	}

}
