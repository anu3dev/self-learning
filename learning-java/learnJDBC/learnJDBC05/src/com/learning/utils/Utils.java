package com.learning.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/javaLearning";
		String userName="root";
		String password="root";
		
		return DriverManager.getConnection(url, userName, password);
	}
	
	public static void closeResource(ResultSet rs, Statement st, Connection c) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(st != null) {
			st.close();
		}
		if(c != null) {
			c.close();
		}
	}
}