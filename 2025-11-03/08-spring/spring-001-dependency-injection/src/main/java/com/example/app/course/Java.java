package com.example.app.course;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Java implements ICourse {

	/**
	 * @Override is not required, but it is strongly recommended 
	 * — because it provides compiler-level safety and clarity.
	 * 
	 * Always use @Override when:
	 * Implementing an interface method ✅
	 * Overriding a superclass method ✅
	 * Implementing methods from an abstract class ✅
	 */
	@Override
	public void purchaseCourse(double price) {
		System.out.println("java course purchased in INR : " + price);	
	}
}
