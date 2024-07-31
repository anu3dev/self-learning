package com.sb.mongoDB.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

// whenever we work we mongoDB, we attach document annotation
@Document
// fetch getter and setter from lombok so we use Data annotation
@Data
public class Employee {
	// id will be unique so using Id annotation
	@Id
	private String id;
	private Integer no;
	private String name;
	private Integer age;
	private String city;
	private float billAmnt;
}
