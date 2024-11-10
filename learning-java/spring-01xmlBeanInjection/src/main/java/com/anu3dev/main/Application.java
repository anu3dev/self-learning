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

/*
 *
 * Distributed Applications - application which communicates with other applications, 
 * for example, payment gateway on any website.
 * Restful  - 100% inter-operatibility and xml and json both option are available
 * 
 */
