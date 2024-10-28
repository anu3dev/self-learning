package com.sb.mongoDB.service;

import java.util.List;

import com.sb.mongoDB.dto.EmployeeDTO;
import com.sb.mongoDB.repo.Employee;

public interface IEmployeeManagement {
	public String registerEmployee(EmployeeDTO empDTO);
	
	public String registerCustomerWithUniqueID(EmployeeDTO empDTO);
	
	public List<Employee> findAllEmployee();
	
    public String removeEmployee(String id);
    
    public List<Employee> fetchByBillAmntBetween(float start, float end);
    
    public List<Employee> fetchByCityIn(String ...cities);
}
