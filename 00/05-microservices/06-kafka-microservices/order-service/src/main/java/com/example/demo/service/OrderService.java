package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.client.ProductClient;
import com.example.demo.dto.OrderResponse;
import com.example.demo.dto.Product;
import com.example.demo.event.OrderCreatedEvent;
import com.example.demo.producer.OrderProducer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrderService {
	private final ProductClient productClient;
	private final OrderProducer orderProducer;
	
	public OrderService(ProductClient productClient, OrderProducer orderProducer) {
		this.productClient = productClient;
		this.orderProducer = orderProducer;
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
		
		// Publish Kafka Event
	    OrderCreatedEvent event = new OrderCreatedEvent(
	            product.getId(),
	            product.getName(),
	            product.getPrice(),
	            "CREATED");

	    orderProducer.publish(event);
		
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
