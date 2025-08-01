package examples.parkinglot;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class EntranceGate {

    private static final AtomicInteger ticketCounter = new AtomicInteger(1);

    public Ticket bookSpot(Vehicle vehicle) {
        ParkingManager parkingManager = ParkingManagerFactory.getParkingManager(vehicle.getType());

        boolean parked = parkingManager.parkVehicle(vehicle);
        if (!parked) {
            return null; // No available spot
        }

        ParkingSpot spot = parkingManager.findSpotByVehicle(vehicle.getLicensePlate()).orElse(null);
        if (spot == null) {
            return null;
        }

        return generateTicket(vehicle, spot);
    }

    private Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        int ticketId = ticketCounter.getAndIncrement();
        return new Ticket(ticketId, vehicle, LocalDateTime.now(), spot);
    }
}