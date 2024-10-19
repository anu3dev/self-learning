package com.sb.helloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.helloWorld.model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		/*
		 * 
		 * SB is indirectly calling ApplicationContext here, first it is calling ConfigurableApplicationContext,
		 * and inside ConfigurableApplicationContext, ApplicationContext is being called.
		 * 
		 * since it is ApplicationContext, eager loading will be there.
		 * 
		 */
		SpringApplication.run(Application.class, args);
		
		Student student1 = new Student();
		System.out.println(student1);
		
		Student student2 = new Student();
		student2.setId(1);
		student2.setName("anu");
		student2.setAge(29);
		student2.setCity("patna");
		System.out.println(student2);
	}
}
