package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.Product;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {
	@GetMapping("/products/{id}")
	Product getProductDetail(@PathVariable int id);
}
