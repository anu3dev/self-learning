package com.telusko.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FirstFlight implements IDelivery {

	
	public FirstFlight()
	{
		System.out.println("First Flight Bean created");
	}
	@Override
	public Boolean deliveryTheProduct(Double Amount) {
		System.out.println("Product Delivered with FirstFlight and AMOUNT PAID IS "+ Amount);
		return true;
	}

}
