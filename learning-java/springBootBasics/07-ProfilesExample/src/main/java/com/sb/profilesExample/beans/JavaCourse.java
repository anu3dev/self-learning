package com.sb.profilesExample.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("java")
public class JavaCourse implements Courses {

	@Override
	public boolean coursePurchase() {
		System.out.println("Java course purchased!");
		return true;
	}
}
