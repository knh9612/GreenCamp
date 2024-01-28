package dev.teabar.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.teabar.dao.TeaDAO;

@WebServlet("/teas/delete")
public class TeaDeleteController extends HttpServlet{
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeaDAO teaDAO = new TeaDAO();
		int id = Integer.parseInt(request.getParameter("delId"));
		
		teaDAO.deleteAll(id);
		
		// forward
//		final String url = "/deletePage.jsp";
//				
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		
//		dispatcher.forward(request, response);

		// 얘는 삭제를 하는 거니까 요청 객체를 유지할 필요가 없음. 기레서 redirect이고
		// 삭제되면 그냥 홈으로 가도록 ㄴㄴ 조회
		String site = "/teas";
		String newURL = request.getContextPath() + site;
		response.sendRedirect(newURL);
		
	}
	
	
}
