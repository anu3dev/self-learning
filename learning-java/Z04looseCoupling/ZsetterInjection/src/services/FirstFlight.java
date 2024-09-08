package services;

public class FirstFlight implements IDeliveryService {
	@Override
	public Boolean deliverProduct(Double amount) {
		System.out.println("Delivered using Firstflight and amount is: " + amount);
		return true;
	}
}