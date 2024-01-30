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
import dev.teabar.model.OrderList;

@WebServlet("/orders")
public class OrderListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeaDAO teaDAO = new TeaDAO();
		List<OrderList> orders = teaDAO.findOrderList();
		
		// 여러 개의 tea 데이터를 .jsp 페이지로 전달
		final String url = "/WEB-INF/orderList.jsp";
		
		// 1. RequestDispatcher를 통해 jsp 페이지로 포워딩(forward)
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		// coffeeList.jsp에게 "orders"라는 이름의 key값으로 orders 데이터를 전달
		request.setAttribute("orders", orders);
		
		dispatcher.forward(request, response); // 실제 이동 진행시켜
	
	}

}
