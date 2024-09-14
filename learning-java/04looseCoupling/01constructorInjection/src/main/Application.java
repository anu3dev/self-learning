package main;

import service.Java;

public class Application {
	
	public static void main(String[] args) {
		
		/*
		 * Constructor Injection
		 */
		LearnCourse course = new LearnCourse(new Java());
		//LearnCourse course = new LearnCourse(new DevOps());
		//LearnCourse course = new LearnCourse(new SpringBoot());
				
		Boolean status = course.buyTheCourse(2500.00);
		if(status)
			System.out.println("success");
		else
			System.out.println("failure");
	}
}
