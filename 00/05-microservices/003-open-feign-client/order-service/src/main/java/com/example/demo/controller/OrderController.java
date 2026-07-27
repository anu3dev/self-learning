package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.ProductClient;
import com.example.demo.dto.Product;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final ProductClient productClient;
	
	public OrderController(ProductClient productClient) {
		this.productClient = productClient;
	}
	
	@GetMapping
	public String defaultMethod() {
		return "Hello From Order Service!!!";
	}
	
	@GetMapping("/{id}")
	public Product placeOrder(@PathVariable int id) {
		return productClient.getProductDetail(id);
	}
}
