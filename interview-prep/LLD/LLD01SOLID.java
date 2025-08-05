package LLD;
/**
 * SOLID principal of OOPS:
 * 
 * S - Single Responsibility Principle
 * O - Open/Closed Principle
 * L - Liskov Substitution Principle
 * I - Interface Segregation Principle
 * D - Dependency Inversion Principle
 */


 
/**
  * Single Responsibility Principle:
  * A class should have only one reason to change, meaning that a class should only have one job or responsibility.
  */
class Marker {
    String name;
    String color;
    String year;
    int price;

    public Marker(String name, String color, String year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }

    public void printInvoice() {
        // Print the invoice details
    }

    public void saveToDB() {
        // Save the invoice to the database
    }
}

/**
 * If you notice Invoice class has multiple responsibilities means multiple reasons to change.
 * Suppose tomorrow we want to change the way we calculate the total, or we want to change how we print the invoice,
 * or we want to change how we save the invoice to the database, we will have to change the Invoice class.
 * This violates the Single Responsibility Principle.
 */

 class InvoiceNew {
    private Marker marker;
    private int quantity;

    public InvoiceNew(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }
}

class InvoiceDao {
    InvoiceNew invoice;

    public InvoiceDao(InvoiceNew invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        // Save the invoice to the database
    }
}

class InvoicePrinter {
    InvoiceNew invoice;

    public InvoicePrinter (InvoiceNew invoice){
        this.invoice = invoice;
    }

    public void printInvoice() {
        // Print the invoice details
    }
}

/**
 * Now we have separated the responsibilities of calculating the total, printing the invoice, and saving the invoice to the database.
 * Each class has only one reason to change, which adheres to the Single Responsibility Principle.
 * 
 * This makes our code more maintainable and easier to understand.
 */


 
 /*
  * Open/Closed Principle:
  * Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
  * This means that the behavior of a module can be extended without modifying its source code.
  */

  class InvoiceDao1 {
    InvoiceNew invoice;

    public InvoiceDao1(InvoiceNew invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        // Save the invoice to the database
    }

    public void saveToFile() {
        // Save the invoice to a file
    }
}

/**
 * If you notice InvoiceDao1 class, for sasaving the invoice to a file, we introduced a new method `saveToFile()`, means we modified the existing class.
 * This violates the Open/Closed Principle, instead of modifying the existing class, we should extend it.    
 */

interface invoicedao2 {
    public void save(InvoiceNew invoice);
}

class DatabaseInvoiceDao implements invoicedao2 {
    @Override
    public void save(InvoiceNew invoice) {
        // Save the invoice to the database
    }
}

class FileInvoiceDao implements invoicedao2 {
    @Override
    public void save(InvoiceNew invoice) {
        // Save the invoice to a file
    }
}

/**
 * Now we have two classes `DatabaseInvoiceDao` and `FileInvoiceDao` that implement the `invoicedao2` interface.
 * This way, we can add new functionality without modifying the existing code, adhering to the Open/Closed Principle.
 */



/*
 * Liskov Substitution Principle:
 * Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
 * This means that subclasses should extend the behavior of the superclass without changing its expected behavior.
 */

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

/*
 * Example usage:
 * Bird bird = new Sparrow();
 * bird.fly(); // Works fine
 * bird = new Ostrich();
 * bird.fly(); // Throws exception, violates LSP
 *
 * Solution: Refactor the hierarchy so that only birds that can fly extend Bird, or introduce an interface for flying capability.
 */

interface Flyable {
    void fly();
}

class BirdLSP {
    public void eat() {
        System.out.println("Bird is eating");
    }
}

class SparrowLSP extends BirdLSP implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class OstrichLSP extends BirdLSP {
    // Ostrich does not implement Flyable, so no fly() method
}

/**
 * Now, SparrowLSP can fly, and OstrichLSP does not implement Flyable, so it does not violate LSP.
 * This way, we can use BirdLSP without worrying about the fly() method for OstrichLSP.
 */



 /**
  * Interface Segregation Principle:
  * Clients should not be forced to depend on interfaces they do not use.
  */

interface RestaurantEmployee {
    void cook();
    void serve();
    void clean();
}

class Chef implements RestaurantEmployee {
    @Override
    public void cook() {
        System.out.println("Chef is cooking");
    }

    @Override
    public void serve() {
        throw new UnsupportedOperationException("Chef does not serve");
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("Chef does not clean");
    }
}

/**
 * This violates the Interface Segregation Principle because Chef is forced to implement methods it does not use.
 */

interface Cookable {
    void cook();
}

interface Serveable {
    void serve();
}

interface Cleanable {
    void clean();
}

class ChefISP implements Cookable {
    @Override
    public void cook() {
        System.out.println("Chef is cooking");
    }
}

class WaiterISP implements Serveable {
    @Override
    public void serve() {
        System.out.println("Waiter is serving");
    }
}

class CleanerISP implements Cleanable {
    @Override
    public void clean() {
        System.out.println("Cleaner is cleaning");
    }
}

/**
 * Now, each employee implements only the interface relevant to their responsibilities,
 * adhering to the Interface Segregation Principle.
 */



/**
 * Dependency Inversion Principle:
 * High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * Class should depend on interfaces or abstract classes, not on concrete implementations.
 */

class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }
}

class Remote {
    private TV tv;

    public Remote() {
        tv = new TV();
    }

    public void pressButton() {
        tv.turnOn();
    }
}

/**
 * This violates the Dependency Inversion Principle because Remote is tightly coupled with the concrete TV class.
 * We should depend on an abstraction instead.
 */

interface Device {
    void turnOn();
}

class TVNew implements Device {
    public void turnOn() {
        System.out.println("TV is ON");
    }
}

class Fan implements Device {
    public void turnOn() {
        System.out.println("Fan is ON");
    }
}

class RemoteNew {
    private Device device;

    public RemoteNew(Device device) {
        this.device = device;
    }

    public void pressButton() {
        device.turnOn();
    }
}

/**
 * Now, RemoteNew depends on the Device interface, not on a concrete implementation.
 * This allows us to use any device that implements the Device interface, adhering to the Dependency Inversion Principle.
 */