package com.anu3dev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.main.service.Alien;

@SpringBootApplication  
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		
		Alien alien = container.getBean(Alien.class);
		alien.disp();
		container.close();
	}
}

/*
 * sequence of logging will be -
 * 
 * static block - Alien Bean
 * Instance Block - Alien Bean
 * Constructor block - Alien Bean
 * @PostConstruct method of Alien
 * Business logic of Alien class - we called this method manually, rest has been done by spring.
 * @PreDestroy - Bean Destroyed
 */
