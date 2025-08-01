package examples.parkinglot;

public abstract class ParkingSpot {
    protected final int spotId;
    protected boolean isEmpty;
    protected Vehicle vehicle;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.isEmpty = true;
        this.vehicle = null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (!canParkVehicle(vehicle)) {
            return false;
        }

        if (!isEmpty) {
            return false; // Spot is already occupied
        }

        this.vehicle = vehicle;
        this.isEmpty = false;
        return true;
    }

    public Vehicle unParkVehicle() {
        if (isEmpty) {
            return null; // No vehicle to unpark
        }

        Vehicle parkedVehicle = this.vehicle;
        this.vehicle = null;
        this.isEmpty = true;
        return parkedVehicle;
    }

    public boolean isOccupied() {
        return !isEmpty;
    }

    public Vehicle getParkedVehicle() {
        return vehicle;
    }

    public int getSpotId() {
        return spotId;
    }

    public abstract int getPrice();

    public abstract VehicleType getSpotType();

    protected abstract boolean canParkVehicle(Vehicle vehicle);
}
