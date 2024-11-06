package com.anu3dev.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anu3dev.main.course.CourseSelection;

public class Application {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		CourseSelection select1 = context.getBean("select1", CourseSelection.class);
		boolean status1 = select1.selectCourse(119.13);
		if(status1) {
			System.out.println("course purchase successful!");
		}
		
		CourseSelection select2 = context.getBean("select2", CourseSelection.class);
		boolean status2 = select2.selectCourse(111.13);
		if(status2) {
			System.out.println("course purchase successful!");
		}
		
		CourseSelection select3 = context.getBean("select3", CourseSelection.class);
		boolean status3 = select3.selectCourse(120.13);
		if(status3) {
			System.out.println("course purchase successful!");
		}
	}
}

