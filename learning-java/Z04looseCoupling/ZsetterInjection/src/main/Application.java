package main;

import services.FedEx;

public class Application {

	public static void main(String[] args) {
		Amazon amz = new Amazon();
		
		/*
		 * setter injection
		 */
		amz.setService(new FedEx());
		//amz.setService(new Bluedart());
		//amz.setService(new FirstFlight());
		
		Boolean status = amz.DeliverTheProduct(2600.00);
		if(status)
			System.out.println("success");
		else
			System.out.println("failure");
	}
}
