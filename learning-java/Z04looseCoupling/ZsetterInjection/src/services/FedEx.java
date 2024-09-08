package services;

public class FedEx implements IDeliveryService {
	@Override
	public Boolean deliverProduct(Double amount) {
		System.out.println("Delivered using Fedex and amount is: " + amount);
		return true;
	}
}