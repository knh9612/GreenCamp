package dev.teabar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.teabar.dao.TeaDAO;
import dev.teabar.model.Tea;

@WebServlet("/teas/update")
public class TeaUpdateController extends HttpServlet{
	
//	private final Logger logger = Logger.getLogger(TeaUpdateController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		TeaDAO teaDAO = new TeaDAO();
		
		int id = Integer.parseInt(request.getParameter("teaId"));
		String name = request.getParameter("teaName");
		String size = request.getParameter("teaSize");
		int price = Integer.parseInt(request.getParameter("teaPrice"));
		
//		logger.info(String.format("id = %d, name = %s, size = %s, price = %d", id, name, size, price));
		
		
		Tea tea = new Tea(id, name, size, price);
		
		teaDAO.update(tea);
		
		String site = "/teas";
		String newURL = request.getContextPath() + site;
		response.sendRedirect(newURL);
	
	}
	
	
}
