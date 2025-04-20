package com.telusko.learning;

import java.util.*;

class Human12
{
	}

class Learner extends Human12
{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Learner(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Learner [age=" + age + ", name=" + name + "]";
	}
	
	
	
}




public class LaunchGen2 {

	public static void main(String[] args) {
		Learner learn=new Learner(15, "Rohan");
		Learner learn1=new Learner(16, "Mehu");
		
		List<Learner> al=new ArrayList<>();
		al.add(learn);
		al.add(learn1);
		//al.add(10);
		
		System.out.println(al);
		
		

	}

}
