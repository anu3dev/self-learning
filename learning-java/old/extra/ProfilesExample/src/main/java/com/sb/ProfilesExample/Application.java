package com.sb.ProfilesExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.sb.ProfilesExample.beans.Courses;
import com.sb.ProfilesExample.beans.JUnitCourse;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private Courses course;
	
	@Value("${myproject.name}")
	private String projectname;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method");
		System.out.println("we are working on" + projectname);
		boolean status = course.coursePurchase();
		System.out.println(status);
	}
	
//	@Bean
//	@Profile("jUnit")
//	public JUnitCourse junitObj() {
//		System.out.println("Customized onj!");
//		return new JUnitCourse();
//	}
} 
