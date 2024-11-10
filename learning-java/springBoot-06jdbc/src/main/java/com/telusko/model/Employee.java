package com.telusko.model;

public class Employee {
	private Integer id;
	private String email_id;
	private String first_name;
	private String last_name;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public Employee() {
		super();
	}
	public Employee(Integer id, String email_id, String first_name, String last_name) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", email_id=" + email_id + ", first_name=" + first_name + ", last_name="
				+ last_name + "]";
	}
}
