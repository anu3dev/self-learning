package com.anu3dev.main.model;

public class Student {
	private int id;
	private String name;
	private int age;
	private String city;
	
	/*
	 * 
	 * static will be called only once when class will be loaded.
	 *  
	 */
	static {
		System.out.println("Student class called - static block");
	}
	
	/*
	 * 
	 * constructor will be called every time when object will be created.
	 *  
	 */
	public Student() {
		super();
		System.out.println("Student - object is being created - constructor");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	/*
	 * 
	 * this method is to print the object.
	 * 
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}
