package com.anu3dev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.dao.EmployeeDAO;
import com.anu3dev.exception.ResourceNotFoundException;
import com.anu3dev.model.Employee;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeDAO dao;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp(){
		return dao.findAll();
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmp(@RequestBody Employee emp) {
		return dao.save(emp);
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmp(@PathVariable Long id) {
		Employee emp = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+ id));
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable Long id, @RequestBody Employee emp) {
		Employee employee = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+ id));
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmailId(emp.getEmailId());
		
		Employee updatedEmp = dao.save(employee);
		return ResponseEntity.ok(updatedEmp);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmp(@PathVariable Long id){
		Employee emp = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+ id));
		dao.delete(emp);
		Map<String, Boolean> res = new HashMap<String, Boolean>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
}
