package com.anu3dev.main.model;

public class Student {
	private Integer id;
	private String name;
	
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
	
	/*
	 * 
	 * static will be called only once while loading the class.
	 * 
	 */
	static {
		System.out.println("Student.class is loading...");
	}
	
	/*
	 * 
	 * Constructor will be Injected here.
	 * Constructor will be called at time of object creation from class.
	 * 
	 */
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("constructor invocked ==> Student obj is created");
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
