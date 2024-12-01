package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.service.ICourse;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
	ICourse course = container.getBean(ICourse.class);
	course.getTheCourse(555.5);
	}
}
