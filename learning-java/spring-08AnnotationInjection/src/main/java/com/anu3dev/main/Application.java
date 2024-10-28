package com.anu3dev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anu3dev.main.config.JavaConfiguration;
import com.anu3dev.main.service.Greetings;

public class Application {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext container = new AnnotationConfigApplicationContext(JavaConfiguration.class);
		Greetings greet = container.getBean(Greetings.class);
		System.out.println(greet.generateGreeeting("Akash"));
	}
}
