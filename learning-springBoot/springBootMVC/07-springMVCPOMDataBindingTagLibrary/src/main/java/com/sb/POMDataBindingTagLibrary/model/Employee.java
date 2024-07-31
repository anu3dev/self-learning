package com.sb.POMDataBindingTagLibrary.model;

import lombok.Data;

@Data
public class Employee {
	private Integer id;
	private String name;
	private String city;
	private Long salary;
	
	public Employee() {
		System.out.println("created by DS");
	}
}
