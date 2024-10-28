/*
 * prepare statement
 */

package com.learning.main;

import java.sql.*;
import java.util.Scanner;

import com.learning.utils.Utils;

public class LaunchMain {
	public static void main(String[] args) {
		Connection connect = null;
		ResultSet result = null;
		PreparedStatement ptmnt=null;
		Scanner scan=null;
		
		try {
			connect = Utils.getDBConnection();
			System.out.println("connection established!");
			
			/*
			 * program 1 ------------------------------------------------------------------------------------------
			 */
			
//			if(connect != null) {
//				String sql = "INSERT INTO studentInfo (sid, sname, sage, saddr) VALUES(?,?,?,?)";
//				ptmnt = connect.prepareStatement(sql);
//			}
//			if(ptmnt != null) {
//				System.out.println("Please enter the following details to be stored in DB");
//				
//				scan = new Scanner(System.in);
//				
//				System.out.println("Enter your id");
//				Integer id = scan.nextInt();
//				
//				System.out.println("Enter your name");
//				String name = scan.next();
//				
//				System.out.println("Enter your age");
//				Integer age = scan.nextInt();
//				
//				System.out.println("Enter your Addrs");
//				String addr = scan.next();
//				
//				ptmnt.setInt(1, id);
//				ptmnt.setString(2, name);
//				ptmnt.setInt(3, age);
//				ptmnt.setString(4, addr);
//				
//				int rowsAffected = ptmnt.executeUpdate();
//				
//				if(rowsAffected==1) {
//					System.out.println("Operation success");
//				} else {
//					System.out.println("Operation failed!");
//				}
//			}
			
			/*
			 * program 2 -------------------------------------------------------------------------------
			 */
			
//			String sql = "DELETE from studentinfo where sid=?";
//			ptmnt = connect.prepareStatement(sql);
//			
//			scan = new Scanner(System.in);
//			System.out.println("Please enter the id which needs to be deleted");
//			Integer id = scan.nextInt();
//			
//			ptmnt.setInt(1, id);
//			
//			int rowsAffected = ptmnt.executeUpdate();
//			
//			if(rowsAffected == 1)
//				System.out.println("Operation Success!");
//			else
//				System.out.println("Operation Failed!");
			
			/*
			 * program 3 ---------------------------------------------------------------------
			 */
			
			if(connect != null) {
				String sql="Select sid, sname, sage, saddr from studentinfo where sid=?";
				ptmnt = connect.prepareStatement(sql);
			}
			if(ptmnt != null) {
			scan=new Scanner(System.in);
			System.out.println("Kindly enter the id ");
			Integer id=scan.nextInt();
			
			ptmnt.setInt(1, id);
			
			result = ptmnt.executeQuery();
			}
			if(result != null) {
				if(result.next()) {
					System.out.println("SID\tSNAME\tSAGE\tSADDR");
					System.out.println(result.getInt("sid") + "\t" + result.getString(2) + "\t" +
					
			        result.getInt(3) + "\t" + result.getString("saddr"));
				}
				else {
					System.out.println("Records not available for this id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				Utils.closeResource(result, ptmnt, connect);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
