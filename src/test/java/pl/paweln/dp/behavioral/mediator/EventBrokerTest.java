package pl.paweln.dp.behavioral.mediator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.mediator.eventbroker.EventBroker;
import pl.paweln.dp.behavioral.mediator.eventbroker.FootballCoach;
import pl.paweln.dp.behavioral.mediator.eventbroker.FootballPlayer;

public class EventBrokerTest {
    private final static Logger logger = LoggerFactory.getLogger(EventBrokerTest.class);


    @Test
    public void testEventBroker() {
        logger.info("Staring Event Broker test ...");

        EventBroker eventBroker = new EventBroker();
        FootballPlayer messi = new FootballPlayer(eventBroker, "Messi");
        FootballPlayer lewandowski = new FootballPlayer(eventBroker, "Lewandowski");

        FootballCoach coach = new FootballCoach(eventBroker);

        messi.score();
        lewandowski.score();
        lewandowski.score();

        Assert.assertEquals(3, coach.getEventsCount());
    }
}
