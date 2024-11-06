package com.anu3dev.main.course;

public class SpringCourse implements ICourse{
	@Override
	public boolean purchaseCourse(Double amount) {
		System.out.println("Spring course with amount " + amount + " INR");
		return true;
	}
}
