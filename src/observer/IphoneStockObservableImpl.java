package observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements Observable {
    private final List<Observer> observerList = new ArrayList<>();


    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

}
