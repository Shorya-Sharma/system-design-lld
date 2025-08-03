package examples.elevatorsystem.myimpl;

import java.util.List;

public class LiftManager implements LiftButtonObserver {
    private final List<Lift> lifts;
    private final List<LiftController> liftControllers;
    private final LiftAllocationStrategy strategy;

    public LiftManager(List<Lift> lifts, List<LiftController> liftControllers, LiftAllocationStrategy strategy) {
        this.lifts = lifts;
        this.liftControllers = liftControllers;
        this.strategy = strategy;
    }

    @Override
    public void onButtonPressed(int floorNo, LiftDirection direction) {
        System.out.println("LiftManager received request at floor " + floorNo + " going " + direction);

        Lift selectedLift = strategy.selectLift(lifts, floorNo, direction);
        if (selectedLift != null) {
            int liftId = selectedLift.getId();
            LiftController controller = liftControllers.get(liftId);
            controller.moveToFloor(floorNo);
        } else {
            System.out.println("No available lift for floor " + floorNo);
        }
    }
}
