package examples.elevatorsystem.myimpl;

import java.util.List;

public interface LiftAllocationStrategy {
    Lift selectLift(List<Lift> lifts, int requestedFloor, LiftDirection direction);
}
