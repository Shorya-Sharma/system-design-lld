package examples.elevatorsystem.ownimpl;

import java.util.ArrayList;
import java.util.List;

public class ExternalLiftButton {
    private final int floorNo;
    private ButtonState state = ButtonState.NOT_PRESSED;
    private final List<LiftButtonObserver> observers = new ArrayList<>();

    public ExternalLiftButton(int floorNo) {
        this.floorNo = floorNo;
    }

    public void pressUp() {
        if (state != ButtonState.PRESSED_UP) {
            state = ButtonState.PRESSED_UP;
            notifyObservers(LiftDirection.UP);
        }
    }

    public void pressDown() {
        if (state != ButtonState.PRESSED_DOWN) {
            state = ButtonState.PRESSED_DOWN;
            notifyObservers(LiftDirection.DOWN);
        }
    }

    public void reset() {
        state = ButtonState.NOT_PRESSED;
    }

    private void notifyObservers(LiftDirection direction) {
        for (LiftButtonObserver observer : observers) {
            observer.onButtonPressed(floorNo, direction);
        }
    }

    public void registerObserver(LiftButtonObserver observer) {
        observers.add(observer);
    }

    public ButtonState getState() {
        return state;
    }

    public int getFloorNo() {
        return floorNo;
    }
}
