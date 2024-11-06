package com.anu3dev.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.telusko.model.Employee;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private DataSource dataSource;
	private String SQL_QUERY = "SELECT * FROM employees";
	
	List<Employee> employess = null;

	@Override
	public List<Employee> getEmployeeInfo(){
		try {
			Connection connection = dataSource.getConnection();			
			PreparedStatement pstmnt = connection.prepareStatement(SQL_QUERY);
			ResultSet rs = pstmnt.executeQuery();
			employess = new ArrayList<>();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setEmail_id(rs.getString("email_id"));
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				employess.add(emp);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employess;
	}
}
