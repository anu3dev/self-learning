package com.sb.mySQLExample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.mySQLExample.model.Student;

@Repository("stuDao")
public class StudentService implements StudentDao {
	public static final String SQL_QUERY = "select id, name, age, city from student";
	
	@Autowired
	private DataSource dataSource;
	
	List<Student> studentList = null;
	
	public StudentService() {
		System.out.println("printing from student dao constructor");
	}
	
	@Override
	public List<Student> getStudents() {
		System.out.println("DataSource : " + dataSource.getClass().getName());
		
		try {
			Connection connect = dataSource.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(SQL_QUERY);
			ResultSet rs = pstmt.executeQuery();
			
			studentList = new ArrayList<>();
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setCity(rs.getString(4));
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
}