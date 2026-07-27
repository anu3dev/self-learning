package com.example.demo;

public class NotificationEmail implements INotification {
	@Override
	public void send(String message) {
		System.out.println("Email : " + message);
	}
}
