package com.anu3dev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anu3dev.main.service.Department;
import com.anu3dev.main.service.Employee;

public class Application {

	public static void main(String[] args){
		@SuppressWarnings("resource")
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig.xml");

		Employee emp = container.getBean(Employee.class);
		System.out.println(emp);
		System.out.println(emp.employeeTask());
		
		Department dep = container.getBean(Department.class);
		System.out.println(dep);
	}
}
