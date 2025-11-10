package main;

import main.course.CourseConstructorInjection;
import main.course.CourseSetterInjection;
import main.course.Java;
import main.course.React;
import main.vehicle.Bus;
import main.vehicle.Car;
import main.vehicle.VehicleConstructorInjection;
import main.vehicle.VehicleSetterInjection;

public class App {
    public static void main(String[] args) throws Exception {      
    	// Example of tightly coupled code:
    	// The main class directly depends on concrete implementations (Car, Bus).
        System.out.println("=== Tightly Coupled Example ===");
        Bus bus = new Bus();
        bus.drive();
        Car car = new Car();
        car.drive();
        
        // Example of loosely coupled code using constructor injection:
        // The dependency (Car/Bus) is provided through the constructor.
        // This allows easy swapping of implementations.
        System.out.println("\n=== Loosely Coupled Example (Constructor Injection) ===");
        VehicleConstructorInjection vehicle1 = new VehicleConstructorInjection(new Bus());
        vehicle1.drive();
        VehicleConstructorInjection vehicle2 = new VehicleConstructorInjection(new Car());
        vehicle2.drive();
        
        CourseConstructorInjection course1 = new CourseConstructorInjection(new Java());
        course1.purchageCourse(1999.00);
        CourseConstructorInjection course2 = new CourseConstructorInjection(new React());
        course2.purchageCourse(2999.00);
        
        
        
	     // Example of loosely coupled code using setter injection:
	     // The dependency is provided via a setter method after object creation.
	     // This is useful when you need to change the dependency at runtime.
	     System.out.println("\n=== Loosely Coupled Example (Setter Injection) ===");
	     VehicleSetterInjection vehicle3 = new VehicleSetterInjection();
	     vehicle3.setVechile(new Bus());
	     vehicle3.drive();
	     vehicle3.setVechile(new Car());
	     vehicle3.drive();
	     
	     CourseSetterInjection course3 = new CourseSetterInjection();
	     course3.setCourse(new Java());
	     course3.purchageCourse(1999.00);
	     course3.setCourse(new React());
	     course3.purchageCourse(1999.00);
    }
}
