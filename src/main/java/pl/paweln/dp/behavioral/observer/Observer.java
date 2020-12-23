package pl.paweln.dp.behavioral.observer;

public interface Observer <T> {
    void handle(PropertyChangeEventArgs<T> args);
}
