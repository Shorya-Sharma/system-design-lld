package observer;

import observer.*;

public class Main {
    public static void main(String[] args) {
        Observable iphoneStockObservable = new IphoneStockObservableImpl();

        Observer observer1 = new MobileObserverImpl("9896514323");
        Observer observer2 = new EmailObserverImpl("xyz@gmail.com");

        iphoneStockObservable.addObserver(observer1);
        iphoneStockObservable.addObserver(observer2);

        // Simulate a change
        iphoneStockObservable.notifyObservers();
    }
}