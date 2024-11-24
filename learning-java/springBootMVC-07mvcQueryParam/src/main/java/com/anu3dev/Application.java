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
 * Query parameter -> 
 * send data from UI to controller in URL
 * query parameter should in end and start with ?
 * query param will represent data in form of key and value pair
 * 
 * localhost:8090/user?name=Anurag
 * localhost:8090/user?name=Anurag&age=26
 * 
 */