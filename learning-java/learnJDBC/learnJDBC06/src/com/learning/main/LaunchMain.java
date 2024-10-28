/*
 * execute() => select or non-select used for all ops => => return type is boolean.
 * if true, return ResultSet =>  PreparedStatement.getResultSet()
 * if false, return int (no of rows affected) => PreparedStatement.getUpdateCount()
 */

package com.learning.main;

import java.sql.*;
import java.util.Scanner;

import com.learning.utils.Utils;

public class LaunchMain {
	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement pstmnt = null;
		ResultSet result = null;
		Scanner scan = null;
		
		try {
			connect = Utils.getDBConnection();
			System.out.println("Connection established!");
			
			if(connect != null) {
				String sql = "UPDATE studentinfo set sname=? where sid=?";
				pstmnt = connect.prepareStatement(sql);
			 
				scan = new Scanner(System.in);
				System.out.println("Please enter info that needs to be updated");
			 
				System.out.println("Kindly enter your id: ");
				Integer id = scan.nextInt();
				System.out.println("Please enter your correct name");
				String name = scan.next();
			 
				pstmnt.setString(1, name);
				pstmnt.setInt(2, id);
			 
				boolean status = pstmnt.execute();
				System.out.println(status);
				
				if(status == true) {
					result = pstmnt.getResultSet();
				} else {
					int rows = pstmnt.getUpdateCount();
					if(rows > 0) {
						System.out.println("Success");
					} else {
						System.out.println("Failed!");
					}
				}
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				Utils.closeResource(result, pstmnt, connect);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

