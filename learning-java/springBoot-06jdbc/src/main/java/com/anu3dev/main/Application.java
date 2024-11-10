package com.anu3dev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.main.dao.EmployeeDaoImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		EmployeeDaoImpl dao = container.getBean(EmployeeDaoImpl.class);
		dao.getEmployeeInfo().forEach(e -> System.out.println(e));
	}

}
