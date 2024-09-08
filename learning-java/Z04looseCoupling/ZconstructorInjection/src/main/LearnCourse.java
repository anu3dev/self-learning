package main;

import service.ICourse;

public class LearnCourse {
	private ICourse course;
	
	public LearnCourse(ICourse course) {
		super();
		this.course = course;
	}
	
	public Boolean buyTheCourse(Double amount) {
		return course.getTheCourse(amount);
	}
}
