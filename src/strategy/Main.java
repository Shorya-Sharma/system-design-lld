package strategy;

public class Main {
    public static void main(String[] args) {
        // Using CreditCardPayment Strategy
        PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardPayment());
        paymentProcessor.processPayment(100.0);

        // Switching to PayPalPayment Strategy
        paymentProcessor.setPaymentStrategy(new PayPalPayment());
        paymentProcessor.processPayment(200.0);

        // Switching to BankTransferPayment Strategy
        paymentProcessor.setPaymentStrategy(new BankTransferPayment());
        paymentProcessor.processPayment(300.0);
    }
}