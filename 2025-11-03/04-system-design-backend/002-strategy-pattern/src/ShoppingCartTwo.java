public class ShoppingCartTwo {
    private IPaymentStrategy paymentStrategy;

    // Set the payment method dynamically - constructor injection
    public ShoppingCartTwo(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}