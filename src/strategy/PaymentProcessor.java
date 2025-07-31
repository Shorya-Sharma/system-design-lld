package strategy;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    // Constructor to inject strategy at runtime
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Method to change the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Delegating the processing of payment to the selected strategy
    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}
