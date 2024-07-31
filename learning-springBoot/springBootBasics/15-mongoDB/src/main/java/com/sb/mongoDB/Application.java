package com.sb.mongoDB;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.mongoDB.dto.EmployeeDTO;
import com.sb.mongoDB.repo.Employee;
import com.sb.mongoDB.service.EmployeeManagement;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeManagement emp = context.getBean(EmployeeManagement.class);
		
		EmployeeDTO dto = new EmployeeDTO(); 
		dto.setNo(1);
		dto.setName("rupa");
		dto.setAge(29);
		dto.setCity("Bengaluru");
		dto.setBillAmnt(444.4f);
		System.out.println(emp.registerEmployee(dto));
		System.out.println(emp.registerCustomerWithUniqueID(dto));
		
		List<Employee> employeeList = emp.findAllEmployee();
		employeeList.forEach(c->System.out.println(c));
		
		System.out.println(emp.removeEmployee("658674c06b51cb45fa9fb1c8"));
		
		emp.fetchByBillAmntBetween(424.4f, 4854.5f).forEach(c->System.out.println(c));
		
		emp.fetchByCityIn("Bengaluru", "Pune", "Chennai").forEach(c->System.out.println(c));
		
		context.close();
	}
}
