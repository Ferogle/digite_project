package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcFactory {
	private JdbcFactory() {
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		Connection conn = DriverManager.getConnection(url, "srikardigite", "oracle");
		System.out.println("reached 1");
		return conn;
	}
}