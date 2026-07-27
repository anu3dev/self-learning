package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.client.ProductClient;
import com.example.demo.dto.OrderResponse;
import com.example.demo.dto.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrderService {
private final ProductClient productClient;
	
	public OrderService(ProductClient productClient) {
		this.productClient = productClient;
	}
	
	@Retry(name = "productService")
	@CircuitBreaker(name = "productService", fallbackMethod = "fallbackCreateOrder")
	public OrderResponse getOrder(int id) {
		Product product = productClient.getProductDetail(id);
		
		OrderResponse orderResponse = new OrderResponse();
		
		orderResponse.setProductId(product.getId());
		orderResponse.setProductName(product.getName());
		orderResponse.setProductPrice(product.getPrice());
		orderResponse.setStatus("CREATED");
		
		return orderResponse;
	}
	
	public OrderResponse fallbackCreateOrder( int id, Exception ex) {
		OrderResponse orderResponse = new OrderResponse();
		
		orderResponse.setProductId(0);
		orderResponse.setProductName("product service down");
		orderResponse.setProductPrice(0);
		orderResponse.setStatus("FAILED");
		
		return orderResponse;
	}
}
