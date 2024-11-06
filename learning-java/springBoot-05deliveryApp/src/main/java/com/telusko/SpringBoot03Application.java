package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.service.Amazon;

@SpringBootApplication
public class SpringBoot03Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringBoot03Application.class, args);
		int count=container.getBeanDefinitionCount();
		System.out.println(count);//52+ 3
		String[] beanNames = container.getBeanDefinitionNames();
		System.out.println("Bean Names are as follows");
		for(String name:beanNames)
		{
			System.out.println(name);
		}
		
		Amazon amz=container.getBean(Amazon.class);
		Boolean status=amz.deliverProduct(5454.4);
		if(status)
			System.out.println("Delivery Sucess");
		else
			System.out.println("Failed to Deliver");
	}

}
