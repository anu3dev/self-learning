package com.learning.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learning.utils.Utils;

public class LaunchMain {
	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement pstmnt = null;
		ResultSet result = null;
		
		try {
			connect = Utils.getDBConnection();
			
			if(connect != null) {
				String sql="UPDATE studentInfo set sname=? where sid=?";
				pstmnt=connect.prepareStatement(sql);
			}
			if(pstmnt != null) {
				pstmnt.setString(1, "Pughaz");
				pstmnt.setInt(2, 1);
				pstmnt.addBatch();
				
				pstmnt.setString(1, "Kalpana");
				pstmnt.setInt(2, 2);
				pstmnt.addBatch();
				
				pstmnt.setString(1, "Lakshmi");
				pstmnt.setInt(2, 3);
				pstmnt.addBatch();
				
				pstmnt.executeBatch();
				System.out.println("Go and check DB table");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Utils.closeResource(result, pstmnt, connect);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
