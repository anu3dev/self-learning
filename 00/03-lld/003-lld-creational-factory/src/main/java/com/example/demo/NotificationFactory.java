package com.example.demo;

public class NotificationFactory {
	public static INotification create(String type) {
		switch (type.toUpperCase()) {
		case "EMAIL":
			return new NotificationEmail();
		case "SMS":
			return new NotificationSMS();
		default:
			return (INotification) new IllegalArgumentException("Unknown type");	
		}
	}
}
