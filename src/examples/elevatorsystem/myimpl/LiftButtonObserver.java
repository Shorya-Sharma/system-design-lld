package examples.elevatorsystem.myimpl;

public interface LiftButtonObserver {
    void onButtonPressed(int floorNo, LiftDirection direction);
}
