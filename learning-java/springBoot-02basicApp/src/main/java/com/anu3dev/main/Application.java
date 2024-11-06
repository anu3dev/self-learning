package com.anu3dev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.anu3dev.main.model.Student;
import com.anu3dev.main.service.StudentService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		/*
		 * 
		 *  In spring, class called as bean.
		 *  
		 */
		Student student1 = context.getBean(Student.class);
		student1.setId(1);
		student1.setName("anurag");
		student1.setAge(30);
		student1.setCity("patna");
		
		Student student2 = context.getBean(Student.class);
		student2.setId(2);
		student2.setName("seema");
		student2.setAge(31);
		student2.setCity("pune");
		
		StudentService service = context.getBean(StudentService.class);
		/*
		 * 
		 * without @Scope(value = "prototype") in Student, 
		 * both student1 and student2 will produce same result due to 
		 * singleton behavior of bean container.
		 * 
		 */
		service.addStudent(student1);
		service.addStudent(student2);
	}
}

/*
 * 
 * @Autowired - used for spring bean auto wiring.
 * 
 * Spring framework provides auto wiring features, means we don’t have to provide bean injection details explicitly.
 *  
 * There are different ways, through which we can achieve auto wiring.
 * 
 * By default in spring, auto wiring is turned off, auto wire value “default” means no auto wiring will be performed,
 * auto wire value “no” also have the same behavior.
 * 
 * auto wire byName - setter method is used for dependency injection, also the variable name should be same 
 * in the class where we will inject the dependency and in the spring bean configuration file.
 * 
 * auto wire byType - class type is used, there should be only one bean configured for this type in the spring bean 
 * configuration file.
 * 
 * auto wire by constructor - This is almost similar to auto wire byType, the only difference is that constructor 
 * is used to inject the dependency.
 * 
 * auto wire by auto detect - If you are on Spring 3.0 or older versions, this is one of the auto wire options available. 
 * his option was used for auto wire by constructor or byType, as determined by Spring container. 
 * 
 * @Autowired annotation can be applied on variables and methods for auto wiring byType. 
 * 
 * We can also use @Autowired annotation on constructor for constructor based spring auto wiring. 
 * 
 * For @Autowired annotation to work, we also need to enable annotation based configuration in spring bean configuration file.
 * 
 * @Qualifier annotation - This annotation is used to avoid conflicts in bean mapping and we need to 
 * provide the bean name that will be used for auto wiring. 
 * 
 * This way we can avoid issues where multiple beans are defined for same type. 
 * This annotation usually works with the @Autowired annotation. 
 * For constructors with multiple arguments, we can use this annotation with the argument names in the method.
 * 
 */

/*
 * 
 * @Scope - only one instance of the spring bean will be created for the spring container and spring 
 * container will return the same instance of MyBean always, means object will be created only once and 
 * will be getting passed for other instances, that is why constructor was printed only once in output.
 * 
 * @Scope annotation can have these values:
 * 
 * @Scope(value="singleton") - this is also default value of scope, helps to make sure bean does 
 * not have shared instance variables, otherwise it might lead to data inconsistency issues.
 * 
 * @Scope(value = "prototype") - new instance will be created every time the bean is requested 
 * from the spring container.
 * 
 * @Scope(value = "request") – same as prototype scope, however it has meant to be used for web 
 * applications. A new instance of the bean will be created for each HTTP request.
 * 
 * @Scope(value = "session") – new bean will be created for each HTTP session by the container.
 * 
 * @Scope(value = "global-session") – used to create global session beans for Port let applications.
 * 
 */


