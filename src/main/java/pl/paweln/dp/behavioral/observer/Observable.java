package pl.paweln.dp.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable <T> {
    List<Observer<T>> observerList = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observerList.add(observer);
    }

    protected void propertyChanged(T source,
                                   String propertyName,
                                   Object newValue) {
        for (Observer<T> o: observerList) {
            o.handle(new PropertyChangeEventArgs<>(source, propertyName, newValue));
        }
    }
}
