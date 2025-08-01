package examples.parkinglot;

public class ParkingManagerFactory {
    
    // Singleton instances for each vehicle type
    private static TwoWheelerParkingManager twoWheelerManager = null;
    private static FourWheelerParkingManager fourWheelerManager = null;

    public static ParkingManager getParkingManager(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> getTwoWheelerManager();
            case FOUR_WHEELER -> getFourWheelerManager();
            default -> throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        };
    }
    
    private static synchronized TwoWheelerParkingManager getTwoWheelerManager() {
        if (twoWheelerManager == null) {
            twoWheelerManager = new TwoWheelerParkingManager(new NearExitParking());
        }
        return twoWheelerManager;
    }
    
    private static synchronized FourWheelerParkingManager getFourWheelerManager() {
        if (fourWheelerManager == null) {
            fourWheelerManager = new FourWheelerParkingManager(new NearEntranceParking());
        }
        return fourWheelerManager;
    }
}