package dev.teabar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "userinfo";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	public static Connection connection;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
            
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if (validateUser(id, password)) {
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			
			if (session.isNew() || session.getAttribute("id") == null) {
                session.setAttribute("id", id);
                out.print("로그인 완료");
                
            } else {
                out.print("이미 로그인 중입니다");
            }
        } else {
            out.print("아이디 또는 비밀번호가 잘못되었습니다");
        }

        out.close();
    }
	
	private boolean validateUser(String id, String password) {
		
	}
	
	
}
