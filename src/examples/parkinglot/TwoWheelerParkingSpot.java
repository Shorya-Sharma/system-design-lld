package examples.parkinglot;

public class TwoWheelerParkingSpot extends ParkingSpot {
    private static final int PRICE = 20; // Price per hour for two-wheeler parking

    public TwoWheelerParkingSpot(int spotId) {
        super(spotId);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public VehicleType getSpotType() {
        return VehicleType.TWO_WHEELER;
    }

    @Override
    protected boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.TWO_WHEELER;
    }
}
