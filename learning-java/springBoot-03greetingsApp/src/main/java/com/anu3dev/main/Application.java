package com.anu3dev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.main.service.GreeetingsService;

@SpringBootApplication  
//==> @ComponentScan + @EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		
		GreeetingsService greet = container.getBean(GreeetingsService.class);
		String status = greet.generateWish("Sai G");
		System.out.println(status);
	}
}
