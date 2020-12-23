package pl.paweln.dp.behavioral.observer.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Event <T> {
    private List<Consumer<T>> consumerList = new LinkedList<>();

    public void subscribe(Consumer<T> consumer) {
        this.consumerList.add(consumer);
    }

    public void fire(T args) {
        for (Consumer<T> consumer : this.consumerList) {
            consumer.accept(args);
        }
    }
}
