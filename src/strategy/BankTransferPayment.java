package strategy;

public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
        // Implement the actual logic for bank transfer payment
    }
}
