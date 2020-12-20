package pl.paweln.dp.behavioral.mediator.eventbroker;

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.ArrayList;
import java.util.List;

public class EventBroker extends Observable<Integer> {

    private List<Observer<? super Integer>> observers = new ArrayList<>();

    @Override
    protected void subscribeActual(Observer<? super Integer> observer) {
        observers.add(observer);
    }

    public void publish(int n) {
        observers.forEach(o -> o.onNext(n));
    }
}
