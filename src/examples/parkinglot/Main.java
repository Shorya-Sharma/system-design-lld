package examples.parkinglot;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Step 1: Setup - create and register some parking spots
        ParkingManager twoWheelerManager = ParkingManagerFactory.getParkingManager(VehicleType.TWO_WHEELER);
        twoWheelerManager.addParkingSpot(new TwoWheelerParkingSpot(1));
        twoWheelerManager.addParkingSpot(new TwoWheelerParkingSpot(2));

        // Create a vehicle
        Vehicle vehicle = new Vehicle("MH12AB1234", VehicleType.TWO_WHEELER);

        // Step 2: Entry Flow
        System.out.println("\n--- ENTRY ---");
        EntranceGate entranceGate = new EntranceGate();

        Ticket ticket = entranceGate.bookSpot(vehicle);
        if (ticket != null) {
            System.out.println("Ticket Issued:");
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Vehicle: " + ticket.getVehicle().getLicensePlate());
            System.out.println("Spot ID: " + ticket.getParkingSpot().getSpotId());
            System.out.println("Entry Time: " + ticket.getEntryTime());
        } else {
            System.out.println("No available spot.");
            return;
        }

        // Simulate time passage (e.g., 2 hours)
        try {
            Thread.sleep(1000); // simulate 1-second delay instead of 2 hours (for testing)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 3: Exit Flow
        System.out.println("\n--- EXIT ---");


        // Initialize ExitGate with ticket and strategy
        ExitGate exitGate = new ExitGate();

        // Choose a payment strategy (Cash or UPI)
        PaymentStrategy payment = new UpiPayment("user@upi");

        // Unpark and pay
        boolean success = exitGate.unPark(ticket, payment);
        if (success) {
            System.out.println("Vehicle exited successfully.");
        } else {
            System.out.println("Exit failed.");
        }
    }
}