package examples.elevatorsystem.ownimpl;

public class Floor {
    private final int floorNo;
    private final ExternalLiftButton liftButton;

    public Floor(int floorNo) {
        this.floorNo = floorNo;
        this.liftButton = new ExternalLiftButton(floorNo);
    }

    public int getFloorNo() {
        return floorNo;
    }

    public ExternalLiftButton getLiftButton() {
        return liftButton;
    }
}
