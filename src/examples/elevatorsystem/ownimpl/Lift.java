package examples.elevatorsystem.ownimpl;

public class Lift {
    private final int id;
    private int currentFloor = 0;
    private LiftDirection direction = LiftDirection.IDLE;
    private LiftState state = LiftState.IDLE;

    private final InternalLiftButton[] internalButtons;

    public Lift(int id, int totalFloors) {
        this.id = id;
        this.internalButtons = new InternalLiftButton[totalFloors];
        // Buttons will be initialized after LiftController is created
    }

    public void initializeInternalButtons(LiftController controller, int totalFloors) {
        for (int i = 0; i < totalFloors; i++) {
            internalButtons[i] = new InternalLiftButton(i, controller);
        }
    }

    public InternalLiftButton getInternalButton(int floor) {
        if (floor < 0 || floor >= internalButtons.length) {
            throw new IllegalArgumentException("Invalid floor number: " + floor);
        }
        return internalButtons[floor];
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public LiftDirection getDirection() {
        return direction;
    }

    public void setDirection(LiftDirection direction) {
        this.direction = direction;
    }

    public LiftState getState() {
        return state;
    }

    public void setState(LiftState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }
}
