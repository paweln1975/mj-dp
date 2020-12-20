package pl.paweln.dp.behavioral.mediator.eventbroker;

public class FootballPlayer {
    private int goals = 0;
    private EventBroker broker;
    private String name;

    public FootballPlayer(EventBroker broker, String name) {
        this.broker = broker;
        this.name = name;
    }

    public void score() {
        broker.publish(++goals);
    }
}
