package examples.parkinglot;

import java.util.List;
import java.util.Optional;

public class NearExitParking implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findAvailableSpot(List<ParkingSpot> parkingSpotList) {
        for (int i = parkingSpotList.size() - 1; i >= 0; i--) {
            ParkingSpot spot = parkingSpotList.get(i);
            if (!spot.isOccupied()) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }
}