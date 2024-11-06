package com.anu3dev.main.payment;

public class QRCode implements IPay {
	@Override
	public boolean makePayment(Double amount) {
		System.out.println("payment using QR code with " + amount + " INR");
		return true;
	}
}
