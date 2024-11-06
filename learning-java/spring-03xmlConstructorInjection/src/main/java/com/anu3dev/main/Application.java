package com.anu3dev.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anu3dev.main.payment.ProcessPayment;

public class Application {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		ProcessPayment select1 = context.getBean("select1", ProcessPayment.class);
		boolean status1 = select1.processPayment(111.36);
		if(status1)
			System.out.println("Transacation successful!");
		
		ProcessPayment select2 = context.getBean("select2", ProcessPayment.class);
		boolean status2 = select2.processPayment(115.37);
		if(status2)
			System.out.println("Transacation successful!");
		
		ProcessPayment select3 = context.getBean("select3", ProcessPayment.class);
		boolean status3 = select3.processPayment(118.96);
		if(status3)
			System.out.println("Transacation successful!");
	}
}
