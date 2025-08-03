package examples.elevatorsystem.myimpl;

public class LiftController {
    private final Lift lift;

    public LiftController(Lift lift) {
        this.lift = lift;
    }

    public void moveToFloor(int targetFloor) {
        if (lift.getState() != LiftState.IDLE) {
            System.out.println("Lift " + lift.getId() + " is currently busy.");
            return;
        }

        int currentFloor = lift.getCurrentFloor();
        LiftDirection direction = determineDirection(currentFloor, targetFloor);

        lift.setDirection(direction);
        lift.setState(LiftState.MOVING);

        System.out.println("Lift " + lift.getId() + " moving from floor " + currentFloor + " to " + targetFloor);

        // simulate immediate arrival
        lift.setCurrentFloor(targetFloor);

        lift.setDirection(LiftDirection.IDLE);
        lift.setState(LiftState.IDLE);

        System.out.println("Lift " + lift.getId() + " arrived at floor " + targetFloor);
    }

    private LiftDirection determineDirection(int current, int target) {
        if (target > current) return LiftDirection.UP;
        if (target < current) return LiftDirection.DOWN;
        return LiftDirection.IDLE;
    }
}
