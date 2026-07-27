package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService service;

	ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Product> defaultMethod() {
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return service.getProductDetail(id);
	}
}
