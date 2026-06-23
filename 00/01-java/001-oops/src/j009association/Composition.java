package j009association;

/**
 * Composition - Strong HAS-A relationship.
 * 
 * If Car dies, Engine dies. Strong ownership.
 */

class Engine {}

class Car {
    private Engine engine = new Engine();
}

public class Composition {}
