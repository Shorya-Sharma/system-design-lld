package examples.elevatorsystem.ownimpl;

public interface LiftButtonObserver {
    void onButtonPressed(int floorNo, LiftDirection direction);
}
