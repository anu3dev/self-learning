 package com.sb.dataJDBCH2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	@Autowired
	private CourseJdbc app;
	
	CourseCommandLineRunner() {
		System.out.println("line");
	}
	
	@Override
	public void run(String... args) throws Exception {
	    app.insertById(new CourseModel(2, "Java"));
	    app.insertById(new CourseModel(3, "Spring Boot"));
	    app.insertById(new CourseModel(4, "Junit"));
	    
	    app.deleteById(2);
	    
	    System.out.println(app.selectById(3));
	    System.out.println(app.selectById(4));
	}
}
