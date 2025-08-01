package examples.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ParkingManager {
    protected List<ParkingSpot> parkingSpots;
    protected ParkingStrategy parkingStrategy;

    public ParkingManager(ParkingStrategy parkingStrategy) {
        this.parkingSpots = new ArrayList<>();
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy) {
        this.parkingSpots = new ArrayList<>(parkingSpots);
        this.parkingStrategy = parkingStrategy;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> availableSpot = parkingStrategy.findAvailableSpot(parkingSpots);

        return availableSpot.map(parkingSpot -> parkingSpot.parkVehicle(vehicle)).orElse(false);

    }

    public Vehicle unParkVehicle(String licensePlate) {
        Optional<ParkingSpot> spotWithVehicle = findSpotByVehicle(licensePlate);

        return spotWithVehicle.map(ParkingSpot::unParkVehicle).orElse(null);

    }

    public Optional<ParkingSpot> findSpotByVehicle(String licensePlate) {
        return parkingSpots.stream()
                .filter(spot -> spot.getParkedVehicle() != null &&
                        spot.getParkedVehicle().getLicensePlate().equals(licensePlate))
                .findFirst();
    }

    public List<ParkingSpot> getOccupiedSpots() {
        return parkingSpots.stream()
                .filter(ParkingSpot::isOccupied)
                .collect(Collectors.toList());
    }

    public List<ParkingSpot> getAvailableSpots() {
        return parkingSpots.stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.toList());
    }

    public boolean addParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot != null) {
            return parkingSpots.add(parkingSpot);
        }
        return false;
    }

    public boolean removeParkingSpot(int spotId) {
        return parkingSpots.removeIf(spot -> spot.getSpotId() == spotId);
    }

    public void clearParkingLot() {
        parkingSpots.forEach(spot -> {
            if (spot.isOccupied()) {
                spot.unParkVehicle();
            }
        });
    }

}
