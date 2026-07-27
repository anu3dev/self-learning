package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;

@Service
public class ProductService {
	List<Product> products = new ArrayList<>();
	
	public ProductService() {
		products.add(new Product(101, "Laptop", 19500));
	    products.add(new Product(102, "Mobile", 25000));
	    products.add(new Product(103, "Keyboard", 1500));
	}
	
	public List<Product> getProducts (){
		return products;
	}
	
	public Product getProductDetail(int productId) {
	    for(Product item : products) {
	    	if(productId == item.getId()) {
	    		return item;
	    	}
	    }
	    return null;
	}
}
