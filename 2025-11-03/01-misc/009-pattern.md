###

####
<details>
<summary> 🟩 solid principle </summary>

- S – Single Responsibility Principle (SRP): A class should have only one reason to change.
- O – Open/Closed Principle (OCP): Software entities should be open for extension, but closed for modification.
- L – Liskov Substitution Principle (LSP): Subtypes must be replaceable for their base types without breaking the program.
- I – Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they don’t use.
- D – Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules; both should depend on abstractions.

</details>

####
<details>
<summary>🟩 What is Singleton?</summary>

- A Singleton is a design pattern that ensures:
    - Only one instance of a class exists
    - That instance is globally accessible
    - Used for:
        - Database connection
        - Logger
        - Configuration manager
        - Caches
        - Thread pools

```java
public class Singleton {
    // To prevent object creation using new. -> constructor private
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

```java
// In Spring, every bean is singleton by default.
// @Service, @Component, @Repository, @Controller -> They are automatically Singleton beans unless you change the scope.

@Service
@Scope("singleton")   // optional, because default is singleton
public class MyService {

}
```
</details>