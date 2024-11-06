package com.anu3dev.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anu3dev.main.model.Employee;

@Repository("dao")
public class EmploeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql="INSERT INTO EMPLOYEE(id, name, city)VALUES(?,?,?)";
		
	public void input(Employee emp) {
		jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getCity());
		System.out.println("Data Inserted");
	}
}
