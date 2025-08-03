package examples.elevatorsystem.myimpl;

public class InternalLiftButton {
    private final int targetFloor;
    private final LiftController controller;

    public InternalLiftButton(int targetFloor, LiftController controller) {
        this.targetFloor = targetFloor;
        this.controller = controller;
    }

    public void press() {
        System.out.println("Internal button for floor " + targetFloor + " pressed.");
        controller.moveToFloor(targetFloor);
    }

    public int getTargetFloor() {
        return targetFloor;
    }
}
