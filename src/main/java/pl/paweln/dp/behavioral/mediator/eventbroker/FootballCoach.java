package pl.paweln.dp.behavioral.mediator.eventbroker;

import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FootballCoach {
    private final static Logger logger = LoggerFactory.getLogger(FootballCoach.class);
    private Disposable subscribe;
    private int events;

    public FootballCoach(EventBroker broker) {
        this.subscribe = broker.subscribe(n -> {
            logger.info("Hey, you scored " + n + " goals!");
            events++;
        });
    }

    public int getEventsCount() {
        return events;
    }
}
