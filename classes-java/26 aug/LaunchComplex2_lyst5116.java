package com.telusko.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee1 implements Comparable<Employee1>
{
	 String name;
	 int age;
	int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee1(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id=id;
	}
	
	public Employee1( int age) {
		super();
		name = "Rohan";
		this.age = age;
		id=3;
	}
	
	public Employee1( ) {
		super();
		name = "Mehu";
		age = 16;
		id=2;
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

	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Employee1 ref1) 
	{
		if(this.id>ref1.id)
			return 1;
		else
			return -1;
		
		
	}
	
	
	
}




public class LaunchComplex2 {

	public static void main(String[] args) {
		Employee1 emp1=new Employee1();
		//System.out.println(emp1);
		
		Employee1 emp2=new Employee1(18);
		//System.out.println(emp2);
		
		Employee1 emp3=new Employee1("Zain",15, 1);
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
