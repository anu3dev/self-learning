package service;

import enums.MembershipType;
import enums.VechileType;

public class MemberShipService {
	public double getMemberShipFee(MembershipType membershipType, VechileType vechileType) {
		double fee = 0.0;
		
		switch (vechileType) {
		case BIKE: 
			switch (membershipType) {
			case PREMIUM:
				fee = 30;
			case GOLD:
				fee = 40;
			case BASIC:
				fee = 50;
			default:
				fee = 0.0;
			}
		case CAR:
			switch (membershipType) {
			case PREMIUM:
				fee = 50;
			case GOLD:
				fee = 60;
			case BASIC:
				fee = 70;
			default:
				fee = 0.0;
			}
		case TRUCK: 
			switch (membershipType) {
			case PREMIUM:
				fee = 80;
			case GOLD:
				fee = 90;
			case BASIC:
				fee = 100;
			default:
				fee = 0.0;
			}
		default:
			fee = 0.0;
		}
		
		return fee;
	}
}
