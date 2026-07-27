package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderResponse;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@GetMapping
	public String defaultMethod() {
		return "Hello From Order Service!!!";
	}
	
	@GetMapping("/{id}")
	public OrderResponse placeOrder(@PathVariable int id) {
		return service.getOrder(id);
	}
}
