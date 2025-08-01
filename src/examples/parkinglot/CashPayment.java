package examples.parkinglot;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Cash.");
        return true;
    }
}