package com.anu3dev.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("jUnit")
public class JUnitCourse implements Courses {

	@Override
	public boolean coursePurchase() {
		System.out.println("Junit course purchased!");
		return true;
	}
}
