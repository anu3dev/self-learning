package Java;
/**
 * Difference between extends and implements in Java:
 * - `extends` is used for class inheritance, allowing a class to inherit properties and methods from another class.
 * - `implements` is used for interface implementation, allowing a class to provide concrete implementations for the methods defined in an interface.
 * - A class can extend only one class (single inheritance) but can implement multiple interfaces (multiple inheritance).
 * - When a class extends another class, it inherits its fields and methods, while when it implements an interface, it must provide implementations for all the methods declared in that interface.
 * - A class can extend a class and implement multiple interfaces at the same time.
 */

 // Example of normal class which can be extended
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

// Cat is a child class of Animal and inherits its properties and methods
// it can also have its own specific methods
// for example, eat method has been inherited from Animal and meow method is specific to Cat
class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows");
    }
}

// Method can also be overridden in the child class
// eat method is inherited from Animal but overridden in Dog
// Dog can also have its own specific methods like bark
class DogEx02 extends Animal {
    @Override
    void eat() {
        System.out.println("Dog eats");
    }

    void bark() {
        System.out.println("Dog barks");
    }
}

// Example of interface implementation
interface Swimmable {
    void swim();
}

// Fish implements the Swimmable interface and provided its own implementation of the swim method
class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Fish swims");
    }
}

// Duck implements the Swimmable interface and provided its own implementation of the swim method
// Duck can also inherit from Animal to have common properties and methods like eat method.
class Duck extends Animal implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}

// Duck implements the Swimmable interface and provided its own implementation of the swim method
// also eat method is inherited from Animal but overridden
class Frog extends Animal implements Swimmable {
    @Override
    void eat() {
        System.out.println("Frog eats");
    }

    @Override
    public void swim() {
        System.out.println("Frog swims");
    }
}

public class J02ExtendsImplements {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();      // Animal eats - inherited from Animal
        cat.meow();     // Cat meows - specific to Cat

        DogEx02 dog = new DogEx02();
        dog.eat();      // Dog eats - overridden from Animal
        dog.bark();     // Dog barks - specific to Dog

        Fish fish = new Fish();
        fish.swim();    // Fish swims - implemented from Swimmable

        Duck duck = new Duck();
        duck.eat();     // Animal eats - inherited from Animal
        duck.swim();   // Duck swims - implemented from Swimmable

        Frog frog = new Frog();
        frog.eat();     // Frog eats - overridden from Animal
        frog.swim();    // Frog swims - implemented from Swimmable
    }
}

