package com.telusko.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Employee
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

	public Employee(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id=id;
	}
	
	public Employee( int age) {
		super();
		name = "Rohan";
		this.age = age;
		id=3;
	}
	
	public Employee( ) {
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
		return "Employee [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
	
}

//class Alpha implements Comparator<Employee>
//{
//
//	@Override
//	public int compare(Employee em1, Employee em2) 
//	{
//		if(em1.age>em2.age)
//			return 1;
//		else
//			return -1;
//		
//		
//	}
//	
//}





public class LaunchComplexSorting {

	public static void main(String[] args) {
		Employee emp1=new Employee();
		//System.out.println(emp1);
		
		Employee emp2=new Employee(18);
		//System.out.println(emp2);
		
		Employee emp3=new Employee("Zain",15, 1);
		//System.out.println(emp3);
		
		ArrayList al=new ArrayList();
		
		al.add(emp1);
		al.add(emp2);
		al.add(emp3);
		//al.add("SOm");
		System.out.println(al);
		
		//Alpha a=new Alpha();
		Comparator<Employee> com= (Employee ref1, Employee ref2)->
		{
			if(ref1.id>ref2.id)
				return 1;
			else
				return -1;
			
		};
		
		
		//Collections.sort(al);
		Collections.sort(al, com);
		
		System.out.println(al);
		
		

	}

}
