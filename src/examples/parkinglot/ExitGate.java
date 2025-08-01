package examples.parkinglot;

import java.time.LocalDateTime;

public class ExitGate {


    public ExitGate() {

    }

    public double computeParkingPrice(Ticket ticket) {
        // Record exit time
        ticket.setExitTime(LocalDateTime.now());

        CostComputationStrategy costStrategy =
                CostComputationStrategyFactory.getStrategy(ticket.getVehicle().getType());

        return costStrategy.computeCost(ticket);
    }

    public boolean unPark(Ticket ticket, PaymentStrategy paymentStrategy) {
        double amount = computeParkingPrice(ticket);

        boolean paid = paymentStrategy.pay(amount);
        if (!paid) {
            System.out.println("Payment failed. Vehicle cannot be unparked.");
            return false;
        }

        ParkingSpot spot = ticket.getParkingSpot();
        Vehicle vehicle = spot.unParkVehicle();
        if (vehicle != null) {
            System.out.println("Vehicle unparked: " + vehicle.getLicensePlate());
        } else {
            System.out.println("No vehicle found in spot.");
        }

        return true;
    }
}