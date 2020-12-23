package pl.paweln.dp.behavioral.observer.event;

public class PropertyChangeEventArgs {
    public final String propertyName;
    public final Object source;
    public final Object value;

    public PropertyChangeEventArgs(Object source, String propertyName, Object value) {
        this.propertyName = propertyName;
        this.source = source;
        this.value = value;
    }
}
