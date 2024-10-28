/*
 * code with industry standard
 */

package com.learning.main;

import java.sql.*;

import com.learning.utils.Utility;

public class LaunchMain {
	public static void main(String[] args) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet result = null;
		
		try {
			connect = Utility.getDBConnection();
			if(connect != null) 
				stmt = connect.createStatement();
			if(stmt != null)
				result = stmt.executeQuery("select sid, sname, sage, saddr from studentinfo");
			if(result != null) {
				System.out.println("ID\tName\tAge\tAddress");
			
				while(result.next()) {
					System.out.println(result.getInt(1) + " \t " + result.getString(2) + " \t " + result.getInt(3) + " \t " + result.getString(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				Utility.closeResource(result, stmt, connect);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
