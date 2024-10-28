package com.anu3dev.main.course;

public class HibernateCourse implements ICourse{
	@Override
	public boolean purchaseCourse(Double amount) {
		System.out.println("Hibernate course with amount " + amount + " INR");
		return true;
	}
}
