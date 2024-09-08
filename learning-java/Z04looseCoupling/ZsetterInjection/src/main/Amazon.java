package main;

import services.IDeliveryService;

public class Amazon {
	private IDeliveryService service;

	public void setService(IDeliveryService service) {
		this.service = service;
	}
	
	public Boolean DeliverTheProduct(Double amount) {
		return service.deliverProduct(amount);
	}
}
