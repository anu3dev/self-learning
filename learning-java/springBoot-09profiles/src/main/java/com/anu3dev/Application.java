package com.anu3dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anu3dev.beans.Courses;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private Courses course;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
		course.coursePurchase();
	}
}

/*
 * Using @Profile annotation, we can do what we were able to do so using @Primary,
 * we can use @Profile annotation and set the same profile in application.properties to run the application.
 * 
 * @Profile annotation can be used with customized class as well.
 */