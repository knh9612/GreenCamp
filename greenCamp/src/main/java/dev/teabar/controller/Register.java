package dev.teabar.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice-register")
public class Register extends HttpServlet {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "userinfo";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	public static Connection connection;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD); // 연결 시키고

			response.setContentType("text/html;charset=UTF-8"); // 왜 response. ? -->

			String id = request.getParameter("id"); // html 태그에 있는 태그 name을 가져와야 하는데 지금 너무 많아서 뭐가뭔지 모르겠
			String password = request.getParameter("password"); // 찾음 register 파일임

			PreparedStatement ps = connection
					.prepareStatement("insert into user (user_id, user_password)" + "values(?,?)");

			ps.setString(1, id);
			ps.setString(2, password);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String site
		String newURL = request.getContextPath();
		response.sendRedirect(newURL);
		
	}
}
