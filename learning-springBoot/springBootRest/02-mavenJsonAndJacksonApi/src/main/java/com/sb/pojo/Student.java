package com.sb.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	private Integer id;
	
	@JsonProperty("Student_Name")
	private String name;
	
	@JsonProperty("Student_City")
	private String city;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
