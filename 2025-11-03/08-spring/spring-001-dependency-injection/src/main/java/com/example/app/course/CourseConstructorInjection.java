package com.example.app.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component is a Spring annotation used to mark a class as a Spring-managed bean.
 * That means Spring will:
 * - Detect it automatically during component scanning.
 * - Instantiate it (create an object).
 * - Manage its life-cycle (including dependency injection).
 */
@Component
public class CourseConstructorInjection {
	private ICourse cou;
	
	/**
	 * @Autowired is spring annotation and it is similar like @Override - a java annotation.
	 * - means not compulsory but always recommended to have.
	 * 
	 * @Autowired handles Runtime dependency injection.
	 * - tells the Spring container to inject a dependency.
	 */
	public CourseConstructorInjection(ICourse course) {
		this.cou = course;
	}
	
	@Autowired
	public void purchaseCourse(double price) {
		cou.purchaseCourse(price);
	}
}
