package com.anu3dev.main.course;

public class CourseSelection {
	
	// target class
	private ICourse course;

	// setter injection
	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	public boolean selectCourse(Double amount) {
		return course.purchaseCourse(amount);
	}
}