package examples.parkinglot;

public class ParkingManagerFactory {

    public static ParkingManager getParkingManager(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerParkingManager(new NearExitParking());
            case FOUR_WHEELER -> new FourWheelerParkingManager(new NearEntranceParking());
            default -> throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        };
    }
}