package com.sb.mongoDB.dto;

import lombok.Data;

// this class is being used to transfer data from one class to another.

@Data
public class EmployeeDTO {
	private Integer no;
	private String name;
	private Integer age;
	private String city;
	private float billAmnt;
}
