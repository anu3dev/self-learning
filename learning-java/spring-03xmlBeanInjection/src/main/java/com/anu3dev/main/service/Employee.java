package com.anu3dev.main.service;

public class Employee {
	private Integer empid;
	private String name;
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		super();
		System.out.println("Employee bean created");
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name +  "]";
	}

	public String employeeTask(){
		return "Every Employee Acts Productive";
	}
}
