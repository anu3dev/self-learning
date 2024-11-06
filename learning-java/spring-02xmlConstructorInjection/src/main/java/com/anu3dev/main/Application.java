package com.anu3dev.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anu3dev.main.model.Student;

public class Application {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("appContext.xml");
		Student student1 = factory.getBean("std1", Student.class);
		System.out.println(student1);
		
		Student student2 = factory.getBean("std2", Student.class);
		System.out.println(student2);
		
		Student student3 = factory.getBean("std3", Student.class);
		System.out.println(student3);
		
		Student student4 = factory.getBean("std4", Student.class);
		System.out.println(student4);
	}
}
