package services;

public class BlueDart implements IDeliveryService {
	@Override
	public Boolean deliverProduct(Double amount) {
		System.out.println("Delivered using Bluedart and amount is: " + amount);
		return true;
	}
}
