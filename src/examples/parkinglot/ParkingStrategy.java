package examples.parkinglot;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {

    Optional<ParkingSpot> findAvailableSpot(List<ParkingSpot> parkingSpots);
}
