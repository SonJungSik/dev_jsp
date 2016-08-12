package com.kedu.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.product.dao.ProductDao;
import com.kedu.product.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDao pDao = ProductDao.getInstance();
		ProductDto pDto = pDao.selectProductByCode(code);
		
		request.setAttribute("product", pDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String product_img = multi.getFilesystemName("product_img");
		String product_img_orn = multi.getOriginalFileName("product_img_orn");
		String description = multi.getParameter("description");
		
		if (product_img == null) {
			product_img = multi.getParameter("nomakeImg");
		}
		
		ProductDto pDto = new ProductDto();
		pDto.setCode(Integer.parseInt(code));
		pDto.setName(name);
		pDto.setPrice(price);
		pDto.setProduct_img(product_img);
		pDto.setProduct_img_orn(product_img_orn);
		pDto.setDescription(description);
		
		ProductDao pDao = ProductDao.getInstance();
		pDao.updateProduct(pDto);
		
		response.sendRedirect("productList.do");
		
	}

}
