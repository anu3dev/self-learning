package com.sb.basicApp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * @Component is a class-level annotation, it is used to denote a class as a Component.
 * have to add @Component annotation if we want to call this class from ApplicationContext.
 */
@Component

/*
 * only one instance of the spring bean will be created for the spring container and spring container will return the same instance of MyBean always.
 * means object was created only once and was getting passed, that is why constructor was being called only once.
 * 
 * @Scope annotation can have these values:
 * 
 * @Scope(value="singleton") - this is also default value of scope, helps to make sure bean does not have shared instance variables,
 * otherwise it might lead to data inconsistency issues.
 * 
 * @Scope(value = "prototype") - new instance will be created every time the bean is requested from the spring container.
 * 
 * @Scope(value = "request") – same as prototype scope, however it has meant to be used for web applications.
 * A new instance of the bean will be created for each HTTP request.
 * 
 * @Scope(value = "session") – new bean will be created for each HTTP session by the container.
 * 
 * @Scope(value = "global-session") – used to create global session beans for Port let applications.
 */
@Scope(value = "prototype")
public class Student {
	private int id;
	private String name;
	private int age;
	private String city;
	
	/*
	 *  static will be called only once when class will be loaded.
	 */
	static {
		System.out.println("Student class called - printing from static block");
	}
	
	/*
	 *  constructor will be called every time when object will be created.
	 */
	public Student() {
		super();
		System.out.println("object is being created from student class  - printing from constructor");
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
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}
