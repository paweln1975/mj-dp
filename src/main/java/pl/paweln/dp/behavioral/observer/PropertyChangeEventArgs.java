package pl.paweln.dp.behavioral.observer;

public class PropertyChangeEventArgs <T> {
    public final T source;
    public final String propertyName;
    public final Object newValue;

    public PropertyChangeEventArgs(T source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}
