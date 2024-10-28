package com.sb.springRestBasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.springRestBasic.pojo.Employee;

@RestController
public class GreetingController {
	@GetMapping("/emp/{id}")
	@ResponseBody
	public Employee employeeDetails(@PathVariable("id") Integer id) {
		Employee emp = new Employee();
		
		if(id == 101){
			emp.setId(101);
			emp.setName("Anurag");
			emp.setCity("Patna");
		} else {
			emp.setId(102);
			emp.setName("Nitish");
			emp.setCity("Pune");
		}
		return emp;
	}
}
