package dev.teabar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.teabar.dao.TeaDAO;
import dev.teabar.model.Tea;

// http://localhost:8080/step05teampractice/teas로 요청 시 동작할 서블릿
@WebServlet("/teas")
public class TeaListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeaDAO teaDAO = new TeaDAO();
		List<Tea> teas = teaDAO.findAll();
		
		// 여러 개의 커피 데이터를 .jsp 페이지로 전달
		final String url = "/WEB-INF/teaList.jsp";
		
		// 1. RequestDispatcher를 통해 jsp 페이지로 포워딩(forward)
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		// coffeeList.jsp에게 "list"라는 이름의 key값으로 coffees 데이터를 전달
		request.setAttribute("list", teas);
		
		dispatcher.forward(request, response); // 실제 이동 진행시켜
	}
	
	
}
