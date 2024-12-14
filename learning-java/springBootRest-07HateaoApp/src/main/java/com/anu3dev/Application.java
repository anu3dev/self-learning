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
 * HATEOAS, which stands for Hypermedia as the Engine of Application State, is a 
 * constraint of the REST application architecture that distinguishes it from most 
 * other network application designs. HATEOAS requires that a client interacts with 
 * a network application entirely through hypermedia provided dynamically by 
 * application servers. A HATEOAS-based service should deliver enough information 
 * within its representations (responses) to allow clients to discover actions 
 * they can perform next without requiring out-of-band information.
 */