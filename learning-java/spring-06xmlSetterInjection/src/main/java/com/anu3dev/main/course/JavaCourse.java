package com.anu3dev.main.course;

public class JavaCourse implements ICourse{
	@Override
	public boolean purchaseCourse(Double amount) {
		System.out.println("Java course with amount " + amount + " INR");
		return true;
	}
}
