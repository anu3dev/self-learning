package com.anu3dev.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anu3dev.dao.EmployeeDAO;
import com.anu3dev.exception.ResourceNotFoundException;
import com.anu3dev.model.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public List<Employee> getAllEmployee() {
		return dao.findAll();
	}

	@Override
	public Employee saveEmployeeData(Employee emp) {
		return dao.save(emp);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeData(Long id) {
		Employee emp = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+ id));
		return ResponseEntity.ok(emp);
	}

	@Override
	public ResponseEntity<Employee> updateEmpoyeeData(Long id, Employee emp) {
		Employee employee = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+ id));
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmailId(emp.getEmailId());
		
		Employee updatedEmp = dao.save(employee);
		return ResponseEntity.ok(updatedEmp);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeData(Long id) {
		Employee emp = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+ id));
		dao.delete(emp);
		Map<String, Boolean> res = new HashMap<String, Boolean>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
}
