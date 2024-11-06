package com.anu3dev.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anu3dev.main.dao.EmploeeDao;
import com.anu3dev.main.model.Employee;

@Component
public class JdbcRunner implements CommandLineRunner {

	@Autowired
	private EmploeeDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		dao.input(new Employee(2,"Rohit","Bengaluru"));

	}
}
