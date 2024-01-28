package dev.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.servlet.dao.TeaDAO;
import dev.servlet.model.Tea;


@WebServlet("/teas/add")
public class AddController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		TeaDAO teaDAO = new TeaDAO();
		
		String name = request.getParameter("teaName");
		String size = request.getParameter("teaSize");
		int price = Integer.parseInt(request.getParameter("teaPrice"));
		
		Tea tea = new Tea(name, size, price);
		
		teaDAO.add(tea);
		
		String site = "/teas";
		String newURL = request.getContextPath() + site;
		response.sendRedirect(newURL);
		
	
	}
	
	
}
