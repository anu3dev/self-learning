package com.sb.basicApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sb.basicApp.dao.StudentDao;
import com.sb.basicApp.model.Student;

@Component
public class StudentService {
	
	/*
	 * Spring framework provides auto wiring features where we don’t need to provide bean injection details explicitly. 
	 * There are different ways through which we can auto wire a spring bean.
	 * 
	 * By default spring bean auto wiring is turned off. Spring bean auto wire default value is “default” that means no auto wiring is to be performed. 
	 * auto wire value “no” also have the same behavior.
	 * 
	 * auto wire byName - setter method is used for dependency injection. 
	 * Also the variable name should be same in the class where we will inject the dependency and in the spring bean configuration file.
	 * 
	 * auto wire byType - class type is used. So there should be only one bean configured for this type in the spring bean configuration file.
	 * 
	 * auto wire by constructor - This is almost similar to auto wire byType, the only difference is that constructor is used to inject the dependency.
	 * 
	 * auto wire by auto detect - If you are on Spring 3.0 or older versions, this is one of the auto wire options available. 
	 * This option was used for auto wire by constructor or byType, as determined by Spring container. 
	 * 
	 * @Autowired annotation - We can use Spring @Autowired annotation for spring bean auto wiring. 
	 * @Autowired annotation can be applied on variables and methods for auto wiring byType. 
	 * We can also use @Autowired annotation on constructor for constructor based spring auto wiring. 
	 * For @Autowired annotation to work, we also need to enable annotation based configuration in spring bean configuration file.
	 *  
	 * @Qualifier annotation - This annotation is used to avoid conflicts in bean mapping and we need to provide the bean name that will 
	 * be used for auto wiring. 
	 * This way we can avoid issues where multiple beans are defined for same type. 
	 * This annotation usually works with the @Autowired annotation. 
	 * For constructors with multiple arguments, we can use this annotation with the argument names in the method.
	 */
	@Autowired
	private StudentDao std;
	
	public void addStudent(Student student) {
		std.save(student);
	}
}
