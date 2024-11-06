package com.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Amazon 
{
	
	private IDelivery service;
	
	public Amazon(IDelivery service)
	{
		this.service=service;
		System.out.println("Amazon Bean created");
	}
	
	@Autowired
	//@Qualifier("fedEx")
	public void setService(IDelivery service) {
		this.service = service;
	}


	public Boolean deliverProduct(Double amount)
	{
		return service.deliveryTheProduct(amount);
		
	}

}
