package examples.elevatorsystem.cacimpl;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar) {

    }
}
