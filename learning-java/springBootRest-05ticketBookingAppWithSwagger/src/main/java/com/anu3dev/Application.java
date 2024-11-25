package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Ticket booking API",
				version = "v1.0",
				description = "This API will book and generate ticket"
				),
		servers = @Server(
				url = "http://localhost:8090/TicketBookingAPI/book-ticket",
				description = "This API is deployed at the this URL"
				)
		)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
