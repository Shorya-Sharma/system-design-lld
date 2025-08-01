package examples.parkinglot;

public class FourWheelerParkingSpot extends ParkingSpot {
    private static final int PRICE = 50; // Price per hour for four-wheeler parking

    public FourWheelerParkingSpot(int spotId) {
        super(spotId);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public VehicleType getSpotType() {
        return VehicleType.FOUR_WHEELER;
    }

    @Override
    protected boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.FOUR_WHEELER;
    }
}
