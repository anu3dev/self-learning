package com.telusko.learning;

import java.util.ArrayList;
import java.util.Collections;

class Employee
{
	private String name;
	private int age;
	
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Employee( int age) {
		super();
		name = "Rohan";
		this.age = age;
	}
	
	public Employee( ) {
		super();
		name = "Mehu";
		age = 16;
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
	
	public String toString()
	{
		return name+ " "+ age;
	}
}


public class LaunchComplexSorting {

	public static void main(String[] args) {
		Employee emp1=new Employee();
		//System.out.println(emp1);
		
		Employee emp2=new Employee(18);
		//System.out.println(emp2);
		
		Employee emp3=new Employee("Rohit",24);
		//System.out.println(emp3);
		
		ArrayList al=new ArrayList();
		
		al.add(emp1);
		al.add(emp2);
		al.add(emp3);
		//al.add("SOm");
		System.out.println(al);
		
		Collections.sort(al);
		
		System.out.println(al);
		
		

	}

}
