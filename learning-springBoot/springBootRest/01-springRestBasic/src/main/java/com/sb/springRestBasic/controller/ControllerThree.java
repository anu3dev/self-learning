package com.sb.springRestBasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.springRestBasic.pojo.Employee;

@RestController
@RequestMapping("/three")
public class ControllerThree {
	// http://localhost:8090/three/emp/101
	// http://localhost:8090/three/emp/105
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
