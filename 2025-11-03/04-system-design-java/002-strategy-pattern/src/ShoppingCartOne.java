public class ShoppingCartOne {
    private IPaymentStrategy paymentStrategy;

    // Set the payment method dynamically - setter injection
    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}