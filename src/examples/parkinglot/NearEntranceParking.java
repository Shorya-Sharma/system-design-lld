package examples.parkinglot;

import java.util.List;
import java.util.Optional;

public class NearEntranceParking implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findAvailableSpot(List<ParkingSpot> parkingSpotList) {
        for (ParkingSpot spot : parkingSpotList) {
            if (!spot.isOccupied()) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }
}