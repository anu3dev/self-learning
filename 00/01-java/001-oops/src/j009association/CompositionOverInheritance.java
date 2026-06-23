package j009association;

/**
 * Use Inheritance when: IS-A relationship exists
 * 
 * Use Composition when: HAS-A relationship exists
 */

class Engine01 {
    void start() {
        System.out.println("Started");
    }
}

class Car01 extends Engine {}

/**
 * Is Car01 an Engine01? - Relationship is wrong.
 * Suppose Engine01 gets: void stop() {}, void repair() {}, void changeOil() {} - Now Car01 automatically gets all methods. 
 * 	Even if they don't make sense. This creates tight coupling.
 */



class Engine02 {
    void start() {
        System.out.println("Started");
    }
}

class Car02 {
    private Engine02 engine;

    public Car02() {
        engine = new Engine02();
    }

    void startCar() {
        engine.start();
    }
}

public class CompositionOverInheritance {}
