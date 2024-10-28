package com.learning.main;

import java.sql.*;

public class LaunchMain {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/javaLearning";
			String userName="root";
			String password="root";
			
			Connection connect = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = connect.createStatement();
			
			String query = "UPDATE studentinfo set sage = 28 where sid = 1";
			/*
			 * executeUpdate() => non-select => used for insert, update and delete => return type is int (no of rows affected)
			 */
			int rowsAffected = stmt.executeUpdate(query);
			
			if(rowsAffected == 1) {
				System.out.println("update success");
			} else {
				System.out.println("update failed");
			}
				
			stmt.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
