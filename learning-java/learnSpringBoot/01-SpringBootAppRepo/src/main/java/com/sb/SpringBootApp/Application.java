package com.sb.SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.SpringBootApp.entity.Employee;
import com.sb.SpringBootApp.entity.EmployeeDetails;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeDetails emp = context.getBean(EmployeeDetails.class);
		
		// an implementation is being added at run time for repository
		System.out.println("Implementing class details" + emp.getClass().getName());
		
		Employee empObj = new Employee();
		empObj.setId(4);
		empObj.setName("amar");
		empObj.setAge(21);
		empObj.setPlace("patna");
		emp.save(empObj);
		System.out.println("Data inserted in table");
		
		context.close();
	}
}
