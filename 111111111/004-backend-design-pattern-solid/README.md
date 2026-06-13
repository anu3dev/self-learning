### SOLID design pattern

- S — Single Responsibility Principle (SRP)
    - One class should have only one reason to change.
    - A class should do one job only. If it handles multiple responsibilities, changes in one part break the other.
    - SRP improves maintainability and reduces ripple-effect changes.

    ```java
    // bad practice
    class OrderService {
        void saveOrder() {}
        void generateInvoice() {}
        void sendEmail() {}
    }


    // good practice
    class OrderRepository { 
        void saveOrder() {} 
    }
    class InvoiceService { 
        void generateInvoice() {} 
    }
    class EmailService { 
        void sendEmail() {} 
    }
    ```

- O — Open / Closed Principle (OCP)
    - Classes should be open for extension but closed for modification.
    - You shouldn’t modify existing code to add new behavior. Instead, extend via interface, inheritance, or composition.
    - OCP avoids breaking existing logic when adding new features.

    ```java
    // bad practice
    if(paymentType.equals("CreditCard")) { 
        ... 
    } else if(paymentType.equals("UPI")) { 
        ... 
    }  


    // good practice
    interface Payment { 
        void pay(); 
    }

    class CreditCardPayment implements Payment { 
        public void pay() {} 
    }
    class UpiPayment implements Payment { 
        public void pay() {} 
    }
    ```

- L — Liskov Substitution Principle (LSP)
    - Subclasses must be usable in place of their parent without breaking functionality.
    - Child class should not weaken the contract of the parent. If B extends A, all objects of A should work perfectly when replaced by objects of B.
    - LSP ensures inheritance is meaningful and safe to substitute.

    ```java
    // bad practice
    class Bird { 
        void fly() {} 
    }
    class Ostrich extends Bird { 
        void fly() { 
            throw new RuntimeException(); 
        } 
    }  


    // good practice
    interface Bird {}
    interface FlyingBird extends Bird { 
        void fly(); 
    }

    class Sparrow implements FlyingBird { 
        public void fly() {} 
    }
    class Ostrich implements Bird {}
    ```

- I — Interface Segregation Principle (ISP)
    - Don’t force a class to implement interfaces it doesn’t use.
    - Break large interfaces into small, specific ones.
    - ISP reduces unnecessary dependencies and keeps interfaces focused.

    ```java
    // bad practice
    interface Worker {
        void work();
        void eat();
    }


    // good practice
    interface Workable { 
        void work(); 
    }
    interface Eatable { 
        void eat(); 
    }

    class Human implements Workable, Eatable { 
        ... 
    }
    class Robot implements Workable { 
        ... 
    }
    ```

- D — Dependency Inversion Principle (DIP)
    - High-level modules should depend on abstractions, not concrete classes.
    - Instead of directly creating objects (tight coupling), depend on interfaces.
    - DIP enables loose coupling, testability, and easier extension.

    ```java
    // bad practice
    class NotificationService {
        EmailSender email = new EmailSender();
    }


    // good practice
    interface MessageSender { 
        void send(String msg); 
    }

    class EmailSender implements MessageSender { 
        ... 
    }
    class SmsSender implements MessageSender { 
        ... 
    }

    class NotificationService {
        private final MessageSender sender;
        NotificationService(MessageSender sender) {
            this.sender = sender;
        }
    }
    ```

- summary
    - S	-> One class = one reason to change
    - O	-> Add new features without modifying old code
    - L -> Subclasses should work wherever parent works
    - I	-> Prefer many small interfaces over one fat interface
    - D -> Depend on abstractions, not concrete implementations