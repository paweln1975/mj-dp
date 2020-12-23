package pl.paweln.dp.behavioral.observer.exercise;

public class EventArgs {
    private EventType type;
    private Object source;

    public EventArgs(Object source, EventType type) {
        this.type = type;
        this.source = source;
    }

    public EventType getType() {
        return type;
    }

    public Object getSource() {
        return source;
    }
}
