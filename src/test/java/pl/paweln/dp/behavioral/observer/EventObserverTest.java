package pl.paweln.dp.behavioral.observer;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.observer.event.Event;
import pl.paweln.dp.behavioral.observer.event.Person;
import pl.paweln.dp.behavioral.observer.event.PropertyChangeEventArgs;

public class EventObserverTest {
    private static final Logger logger = LoggerFactory.getLogger(EventObserverTest.class);
    private static int count = 0;
    @Test
    public void testObserver() {
        logger.info("Event Observer test ...");
        Person person = new Person();
        Event<PropertyChangeEventArgs>.Subscription subscription =  person.propertyChange.addHandler(
                (propertyChangeEventArgs -> {
                    logger.info("Property " + propertyChangeEventArgs.propertyName +
                            " changed to:" + propertyChangeEventArgs.value);
                    count++;
                })
        );
        person.setAge(15);
        person.setAge(20);
        subscription.close();
        person.setAge(25);
        Assert.assertEquals(2, count);
    }
}
