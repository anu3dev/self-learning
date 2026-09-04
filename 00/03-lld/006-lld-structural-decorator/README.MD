# Decorator Design Pattern

The **Decorator Design Pattern** is a **Structural Design Pattern** that allows you to **add new functionality to an object dynamically without modifying its existing code**.

Unlike inheritance, where behaviour is fixed at compile time, the Decorator Pattern lets you combine features at runtime by wrapping one object inside another.

---

# Why Do We Need the Decorator Pattern?

Imagine a coffee shop.

A simple coffee costs:

```text
Coffee = ₹100
```

Now customers want customizations.

Customer 1:

```text
Coffee + Milk = ₹120
```

Customer 2:

```text
Coffee + Milk + Sugar = ₹130
```

Customer 3:

```text
Coffee + Milk + Sugar + Chocolate
```

Customer 4:

```text
Coffee + Chocolate + Cream
```

Customer 5:

```text
Coffee + Caramel + Milk + Sugar
```

---

# The Problem with Inheritance

If we use inheritance, we'd need classes like:

```text
CoffeeWithMilk

CoffeeWithSugar

CoffeeWithChocolate

CoffeeWithMilkSugar

CoffeeWithMilkChocolate

CoffeeWithMilkSugarChocolate

CoffeeWithMilkSugarChocolateCream

...
```

Very quickly, the number of classes explodes.

This is known as the **Class Explosion Problem**.

Maintaining such a design becomes impossible.

---

# Solution — Decorator Pattern

Instead of creating hundreds of subclasses,

we wrap an existing object with decorators.

Each decorator adds one new behaviour.

```text
Coffee

    │

    ▼

MilkDecorator

    │

    ▼

SugarDecorator

    │

    ▼

ChocolateDecorator

    │

    ▼

CaramelDecorator
```

Each decorator contributes one additional feature.

---

# Real-World Analogy

Imagine ordering a pizza.

Start with:

```text
Pizza
```

Then customize it:

```text
Pizza

↓

Extra Cheese

↓

Mushrooms

↓

Olives

↓

Jalapeños
```

Each topping wraps the existing pizza.

No new pizza classes are required.

---

# Structure

```text
              Component
                  ▲
                  │
          Concrete Component
                  ▲
                  │
             Decorator
                  ▲
                  │
      Concrete Decorators
```

---

# Coffee Example

```text
Coffee

↓

MilkDecorator

↓

SugarDecorator

↓

ChocolateDecorator
```

Each decorator wraps the previous object.

---

# Java Implementation

## Step 1 — Component Interface

```java
interface Coffee {

    String description();

    double cost();

}
```

This is the common interface shared by all coffee objects and decorators.

---

## Step 2 — Concrete Component

```java
class BasicCoffee implements Coffee {

    @Override
    public String description() {
        return "Coffee";
    }

    @Override
    public double cost() {
        return 100;
    }

}
```

This is the base object.

---

## Step 3 — Abstract Decorator

```java
abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

}
```

Notice that the decorator **implements the same interface** and **contains another Coffee object**.

This is the key idea behind the Decorator Pattern.

---

## Step 4 — Milk Decorator

```java
class MilkDecorator extends CoffeeDecorator {

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 20;
    }

}
```

Milk adds:

- Description
- Additional cost

---

## Step 5 — Sugar Decorator

```java
class SugarDecorator extends CoffeeDecorator {

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 10;
    }

}
```

Sugar also wraps another Coffee object.

---

## Step 6 — Client

```java
Coffee coffee = new SugarDecorator(
                    new MilkDecorator(
                        new BasicCoffee()));

System.out.println(coffee.description());
System.out.println(coffee.cost());
```

---

## Output

```text
Coffee + Milk + Sugar

130.0
```

---

# What Happens Internally?

```text
BasicCoffee

↓

MilkDecorator

↓

SugarDecorator
```

Execution Flow:

```text
coffee.description()

↓

SugarDecorator

↓

MilkDecorator

↓

BasicCoffee

↓

Returns "Coffee"

↓

Milk adds " + Milk"

↓

Sugar adds " + Sugar"
```

Final Result:

```text
Coffee + Milk + Sugar
```

Cost Calculation:

```text
Basic Coffee

100

↓

Milk

+20

↓

Sugar

+10

↓

130
```

---

# UML Diagram

```text
                +----------------------+
                |       Coffee         |
                +----------------------+
                | + description()      |
                | + cost()             |
                +----------▲-----------+
                           │
                           │
                +----------------------+
                |    BasicCoffee       |
                +----------------------+

                           ▲
                           │
                +----------------------+
                |  CoffeeDecorator     |
                +----------------------+
                | - coffee : Coffee    |
                +----------▲-----------+
                           │
          ┌────────────────┴───────────────┐
          ▼                                ▼
+----------------------+        +----------------------+
|    MilkDecorator     |        |   SugarDecorator     |
+----------------------+        +----------------------+
```

---

# Why Is This Powerful?

You can wrap objects infinitely.

```text
Coffee

↓

Milk

↓

Sugar

↓

Chocolate

↓

Caramel

↓

Cream

↓

Vanilla

↓

Hazelnut
```

No matter how many combinations customers want,

you never create additional subclasses.

---

# Before vs After Decorator

## Without Decorator

```text
CoffeeWithMilk

CoffeeWithSugar

CoffeeWithChocolate

CoffeeWithMilkSugar

CoffeeWithMilkChocolate

CoffeeWithSugarChocolate

CoffeeWithMilkSugarChocolate

...
```

Huge number of classes.

---

## With Decorator

```text
Coffee

↓

Milk

↓

Sugar

↓

Chocolate

↓

Caramel
```

Simple.

Flexible.

Maintainable.

---

# Production Examples

## 1. Spring Boot

One of the best-known examples:

```text
HttpServletRequest

↓

HttpServletRequestWrapper
```

The wrapper adds new behaviour while preserving the original interface.

---

## 2. Java I/O

```text
InputStream

↓

BufferedInputStream

↓

DataInputStream
```

Each wrapper adds extra functionality.

---

## 3. BufferedReader

```text
Reader

↓

BufferedReader
```

Adds buffering without changing the Reader interface.

---

## 4. Collections Framework

```java
Collections.synchronizedList(list)
```

Returns a decorated version of the list that adds thread safety.

---

## 5. Java Streams

```text
FileInputStream

↓

BufferedInputStream

↓

DataInputStream
```

Multiple decorators can be chained together.

---

# Advantages

- Adds behaviour dynamically.
- Avoids subclass explosion.
- Follows the Open/Closed Principle.
- Supports runtime composition.
- Small, reusable classes.
- Highly flexible.

---

# Disadvantages

- Many small objects may be created.
- Debugging can become harder due to multiple wrappers.
- Wrapping order can affect behaviour.

---

# When Should You Use Decorator?

Use Decorator when:

- Features are optional.
- Behaviour needs to be added dynamically.
- You want to avoid creating many subclasses.
- You need runtime flexibility.

---

# When Should You Avoid Decorator?

Avoid Decorator when:

- The object never changes.
- Behaviour is fixed.
- A simple inheritance hierarchy is sufficient.

---

# Decorator vs Inheritance

| Inheritance | Decorator |
|-------------|-----------|
| Behaviour fixed at compile time | Behaviour added at runtime |
| Large class hierarchies | Small reusable decorators |
| Difficult to extend | Easy to extend |
| Class explosion | Composition-based solution |

---

# Adapter vs Decorator

This is one of the most frequently asked interview questions.

| Adapter | Decorator |
|----------|-----------|
| Changes the interface | Keeps the same interface |
| Makes incompatible classes work together | Adds new behaviour to an existing object |
| Focuses on compatibility | Focuses on enhancement |
| Structural Pattern | Structural Pattern |
| Used during integration | Used for runtime feature extension |

---

# Interview Questions

## What problem does the Decorator Pattern solve?

It allows new functionality to be added to an object dynamically without modifying its existing code or creating numerous subclasses.

---

## Why not simply use inheritance?

Inheritance creates a large number of subclasses for every feature combination.

Decorator avoids this by composing behaviour at runtime.

---

## Can multiple decorators wrap the same object?

Yes.

That is the primary advantage of the pattern.

Example:

```text
Coffee

↓

Milk

↓

Sugar

↓

Chocolate

↓

Caramel
```

---

## Does Decorator change the object's interface?

No.

The decorator implements the same interface as the original object.

Clients continue using the object exactly the same way.

---

# Practice Exercise

Implement the following decorators:

- ChocolateDecorator (+₹30)
- CaramelDecorator (+₹25)
- CreamDecorator (+₹15)

Create the following combinations:

```text
Coffee + Chocolate

Coffee + Milk + Chocolate

Coffee + Milk + Sugar + Chocolate + Caramel
```

Print:

- Description
- Total Cost

---

# Key Takeaways

- Decorator is a **Structural Design Pattern**.
- It adds behaviour dynamically at runtime.
- It avoids the **Class Explosion Problem**.
- Decorators wrap existing objects rather than modifying them.
- Multiple decorators can be chained together.
- The original interface remains unchanged.
- Common Java examples include **BufferedReader**, **BufferedInputStream**, **Collections.synchronizedList()**, and **HttpServletRequestWrapper**.

---

# Which Spring Boot features use these patterns?
- Decorator: HttpServletRequestWrapper, BufferedReader

---

> ## Interview Tip
>
> Remember this simple rule:
>
> - **Adapter changes the interface.**
> - **Decorator adds behaviour.**
>
> If you're integrating incompatible APIs, think **Adapter**.
>
> If you're adding optional features without creating dozens of subclasses, think **Decorator**.