package com.sb.profilesExample.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("springBoot")
public class SpringBootCourse implements Courses {

	@Override
	public boolean coursePurchase() {
		System.out.println("Spring boot course purchased!");
		return true;
	}
}
