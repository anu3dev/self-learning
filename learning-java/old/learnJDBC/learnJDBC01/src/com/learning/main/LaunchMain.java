package com.learning.main;

import java.sql.*;

public class LaunchMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * load and register the driver
		 */
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/*
		 * establish the connection
		 */
		String url="jdbc:mysql://localhost:3306/javaLearning";
		String userName="root";
		String password="root";

		Connection connect = DriverManager.getConnection(url, userName, password);
		
		/*
		 * create statement object
		 */
		Statement stmt = connect.createStatement();
		
		/*
		 * execute query
		 */
		String query = "select sid, sname, sage, saddr from studentinfo";
		
		/*
		 * executeQuery() => select => used for data retrival => return type is ResultSet
		 */
		ResultSet result = stmt.executeQuery(query);
		
		/*
		 * process the data
		 */
		System.out.println("ID\tName\tAge\tAddress");
		while(result.next()) {
			System.out.println(result.getInt(1) + " \t " + result.getString(2) + " \t " + result.getInt(3) + " \t " + result.getString(4));
		}
		
		/*
		 * close the resource
		 */
		result.close();
		stmt.close();
		connect.close();
	}
}
