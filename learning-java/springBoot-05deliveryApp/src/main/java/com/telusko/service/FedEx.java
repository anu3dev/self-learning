package com.telusko.service;

import org.springframework.stereotype.Service;

@Service
public class FedEx implements IDelivery 
{
	
	public FedEx()
	{
		System.out.println("FedEx Bean created");
	}

	@Override
	public Boolean deliveryTheProduct(Double Amount)
	{
		System.out.println("Product Delivered with FedEx and AMOUNT PAID IS "+ Amount);
		return true;
	}

}
