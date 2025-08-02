package examples.elevatorsystem.ownimpl;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Floor> floors;
    private final List<Lift> lifts;
    private final List<LiftController> liftControllers;
    private final LiftManager liftManager;

    public Building(int numFloors, int numLifts) {
        floors = new ArrayList<>();
        lifts = new ArrayList<>();
        liftControllers = new ArrayList<>();

        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }

        for (int i = 0; i < numLifts; i++) {
            Lift lift = new Lift(i, numFloors);
            LiftController controller = new LiftController(lift);
            lift.initializeInternalButtons(controller, numFloors);
            lifts.add(lift);
            liftControllers.add(controller);
        }

        liftManager = new LiftManager(lifts, liftControllers, new NearestIdleLiftStrategy());

        for (Floor floor : floors) {
            floor.getLiftButton().registerObserver(liftManager);
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Lift> getLifts() {
        return lifts;
    }

    public LiftManager getLiftManager() {
        return liftManager;
    }

    public LiftController getLiftController(int liftId) {
        return liftControllers.get(liftId);
    }
}
