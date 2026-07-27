package com.example.demo;

public class NotificationSMS implements INotification {
	@Override
	public void send(String message) {
		System.out.println("SMS : " + message);
	}
}
