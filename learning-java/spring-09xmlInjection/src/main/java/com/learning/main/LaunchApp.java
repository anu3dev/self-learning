package com.learning.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.beans.FlipKart;

public class LaunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory=new ClassPathXmlApplicationContext("applicationcontext.xml");
		FlipKart fk=factory.getBean("flipkart", FlipKart.class);
		
		boolean status=fk.shipment(new String[] {"SpringBoot", "Java"});
		if(status)
			System.out.println("Delivered successfully");
		else
			System.out.println("Failed to delivered");
	}

}
