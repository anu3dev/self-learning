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
			
			String getQuery = "select sid, sname, sage, saddr from studentinfo";
			// String updateQuery = "INSERT INTO studentinfo (sid, sname, sage, saddr)" + "VALUES(2, 'Nit', 25, 'Pune')";
			String deleteQuery = "DELETE from studentinfo where sid=2";
			
			/*
			 * executeUpdate() => non-select => used for insert, update and delete => return type is int (no of rows affected)
			 */
			int rowsAffected = stmt.executeUpdate(deleteQuery);
			
			if(rowsAffected == 1) {
				// System.out.println("data inserted successfully");
				System.out.println("data deleted successfully");
			} else {
				// System.out.println("Failed to insert the data");
				System.out.println("Failed to deleted the data");
			}
			
			ResultSet result = stmt.executeQuery(getQuery);

			System.out.println("ID\tName\tAge\tAddress");
			while(result.next()) {
				System.out.println(result.getInt(1) + " \t " + result.getString(2) + " \t " + result.getInt(3) + " \t " + result.getString(4));
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
