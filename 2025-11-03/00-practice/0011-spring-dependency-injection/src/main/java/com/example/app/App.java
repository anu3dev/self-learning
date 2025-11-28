package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.app.course.CourseConstructorInjection;
import com.example.app.course.CourseSetterInjection;
import com.example.app.course.ICourse;
import com.example.app.course.Java;
import com.example.app.course.React;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(App.class, args);
		
		// -------------------------------------------------------------
        // Example 1: TIGHTLY COUPLED CODE
        // -------------------------------------------------------------
		System.out.println("=== Tightly Coupled Example ===");
		
		// Direct object creation using 'new' keyword.
        // The main class is tightly bound to specific implementations (Java, React).
        // If we need to change the course type, we must modify this code.
		Java java = new Java();
		java.purchaseCourse(1999.00);
		React react = new React();
		react.purchaseCourse(2999.00);
		
		
		
		// -------------------------------------------------------------
        // Example 2: LOOSELY COUPLED CODE (Spring Dependency Injection)
        // -------------------------------------------------------------
		System.out.println("\n=== Loosely Coupled Example ===");
		
		// Option 1: Get a specific implementation from Spring (Java)
        // Spring manages the bean life-cycle; we just ask for the bean.
        // This is still somewhat specific but managed by the IoC container.
		ICourse course = context.getBean(Java.class);
		course.purchaseCourse(1999.00);
		
		// Option 2: get another implementation (React)
        ICourse reactCourse = context.getBean(React.class);
        reactCourse.purchaseCourse(2999.00);
        
        
        
        // -------------------------------------------------------------
        // Example 3: Constructor Injection
        // -------------------------------------------------------------
        System.out.println("\n=== Loosely Coupled - Constructor Injection ===");
        
        /**
         * In constructor injection, the dependency (ICourse) is injected
         * via the class constructor. This is preferred because:
         * - The dependency is provided at object creation time (immutable).
         * - Makes the object easier to test (dependencies are explicit).
         * 
         * Here, CourseConstructorInjection has an @Autowired constructor
         * that expects an ICourse implementation.
         * 
         * Since both React and Java classes are annotated with @Component,
         * Spring finds two beans of type ICourse during dependency injection.
         * This causes ambiguity — Spring doesn't know which one to inject.
         * 
         * To resolve this, we can:
         * ✅ Mark one implementation with @Primary (default bean), OR
         * ✅ Use @Qualifier("beanName") in the constructor parameter.
         */
        CourseConstructorInjection courseBean1 = context.getBean(CourseConstructorInjection.class);
        courseBean1.purchaseCourse(3999.00);
        
        
        
        // -------------------------------------------------------------
        // Example 4: Setter Injection (if you have a setter-based class)
        // -------------------------------------------------------------
        System.out.println("\n=== Loosely Coupled - Setter Injection ===");
        
        /**
         * In setter injection, the dependency is provided *after* object creation
         * through a setter method.
         * 
         * This approach allows changing the dependency at runtime (more flexible),
         * but makes the object mutable and harder to test compared to constructor injection.
         */
        CourseSetterInjection courseBean2 = context.getBean(CourseSetterInjection.class);
        courseBean2.purchaseCourse(3999.00);
	}
}
