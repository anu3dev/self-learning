package com.sb.mongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.mongoDB.dto.EmployeeDTO;
import com.sb.mongoDB.generator.IdGenerator;
import com.sb.mongoDB.repo.Employee;
import com.sb.mongoDB.repo.IEmployeeRepo;

@Service
public class EmployeeManagement implements IEmployeeManagement {
	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public String registerEmployee(EmployeeDTO empDTO) {
		System.out.println("proxy class name for mongoDB " + repo.getClass().getName());
		Employee document = new Employee();
		BeanUtils.copyProperties(empDTO, document);
		Employee doc = repo.save(document);
		return "Data inserted with id " + doc.getId();
	}
	
	@Override
	public String registerCustomerWithUniqueID(EmployeeDTO dto) {
		System.out.println("Imp class name for Mongo Repo "+ repo.getClass().getName());
		Employee document=new Employee();
		document.setId(IdGenerator.generateId());
		BeanUtils.copyProperties(dto, document);
		Employee doc = repo.save(document);
		return "Data inserted with unique id "+doc.getId();
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		return repo.findAll();
	}

	@Override
	public String removeEmployee(String id) {
		Optional<Employee> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Employee deleted ";
		}
		return "Employee doc not found";
	}

	@Override
	public List<Employee> fetchByBillAmntBetween(float start, float end) {
		return repo.findByBillAmntBetween(start, end);
	}

	@Override
	public List<Employee> fetchByCityIn(String... cities) {
		return repo.findByCityIn(cities);
	}
}
