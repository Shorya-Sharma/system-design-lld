package examples.elevatorsystem.myimpl;

import java.util.List;

public class NearestIdleLiftStrategy implements LiftAllocationStrategy {
    @Override
    public Lift selectLift(List<Lift> lifts, int requestedFloor, LiftDirection direction) {
        Lift selectedLift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            if (lift.getState() == LiftState.IDLE) {
                int distance = Math.abs(lift.getCurrentFloor() - requestedFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedLift = lift;
                }
            }
        }

        return selectedLift;
    }
}
