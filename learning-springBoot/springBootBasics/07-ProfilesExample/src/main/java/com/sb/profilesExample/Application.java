package com.sb.profilesExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.profilesExample.beans.Courses;

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
