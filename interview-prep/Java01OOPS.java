/*
 * Object-Oriented Programming (OOP) in Java is a programming paradigm based on the concept of "objects",
 * which can contain data (fields) and code (methods). The four main principles of OOP are:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Polymorphism
 * 4. Abstraction
 */

// 1. Encapsulation: Wrapping data (fields) and methods into a single unit (class), and restricting direct access.
class Person {
    private String name; // private field, cannot be accessed directly outside the class

    public Person(String name) {
        this.name = name;
    }

    public String getName() { // public method to access private field
        return name;
    }

    public void setName(String name) { // public method to modify private field
        this.name = name;
    }
}

// 2. Inheritance: Mechanism where one class acquires properties and behaviors of another class.
class Employee extends Person { // Employee inherits from Person
    private int employeeId;

    public Employee(String name, int employeeId) {
        super(name); // call constructor of Person
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

// 3. Polymorphism: Ability to take many forms. In Java, achieved via method overriding and interfaces.
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() { // method overriding
        System.out.println("Dog barks");
    }
}

// 4. Abstraction: Hiding complex implementation details and showing only essential features.
abstract class Shape { // abstract class cannot be instantiated
    abstract double area(); // abstract method
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

// Example usage:
public class Java01OOPS {
    public static void main(String[] args) {
        // Encapsulation
        Person p = new Person("Alice");
        System.out.println("Person name: " + p.getName());
        p.setName("Bob");
        System.out.println("Updated name: " + p.getName());

        // Inheritance
        Employee e = new Employee("Charlie", 101);
        System.out.println("Employee name: " + e.getName() + ", ID: " + e.getEmployeeId());

        // Polymorphism
        Animal a = new Dog(); // Animal reference, Dog object
        a.makeSound(); // Output: Dog barks

        // Abstraction
        Shape s = new Circle(5);
        System.out.println("Circle area: " + s.area());
    }
}