package com.anu3dev.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.anu3dev.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployee();
	public Employee saveEmployeeData(Employee emp);
	public ResponseEntity<Employee> getEmployeeData(Long id);
	public ResponseEntity<Employee> updateEmpoyeeData(Long id, Employee emp);
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeData(Long id);
}
