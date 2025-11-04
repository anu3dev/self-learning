###

- Abstraction in TypeScript and Java is conceptually the same, abstraction is hiding internal details and exposing only what’s necessary, it can be achieved using Abstract Classes(partial abstraction) and Interfaces(full abstraction)


####
<details>
<summary> 🟩 abstract class in typescript </summary>

```typescript
abstract class Vehicle {
  // abstract method → no body, must be implemented by subclass
  abstract start(): void;

  // normal method → shared logic
  stop(): void {
    console.log("Vehicle stopped.");
  }
}

class Car extends Vehicle {
  start(): void {
    console.log("Car started with key or button.");
  }
}

const myCar = new Car();
myCar.start(); // ✅ "Car started with key or button."
myCar.stop();  // ✅ "Vehicle stopped."
```

</details>


####
<details>
<summary> 🟩 interface in typescript </summary>

```typescript
interface PaymentGateway {
  makePayment(amount: number): void;
}

class PayPal implements PaymentGateway {
  makePayment(amount: number): void {
    console.log(`Paid $${amount} using PayPal.`);
  }
}

const payment = new PayPal();
payment.makePayment(100); // ✅ "Paid $100 using PayPal."
```

</details>
