package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
 * 
 * Path parameter -> 
 * send data from UI to controller in URL
 * path parameter can be present anywhere in url
 * path param will represent data in form of only value not key
 * 
 * http://localhost:8090/employee/Anurag
 * http://localhost:8090/employee/Anurag/admin
 * 
 */