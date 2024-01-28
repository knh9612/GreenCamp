package dev.teabar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "teabar";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	// Java와 MySQL Database 연결
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}

	// 자원 해제할 때 사용하는 유틸 메서드
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}