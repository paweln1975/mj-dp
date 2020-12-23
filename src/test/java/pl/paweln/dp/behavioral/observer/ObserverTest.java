package pl.paweln.dp.behavioral.observer;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverTest {
    private static final Logger logger = LoggerFactory.getLogger(ObserverTest.class);
    @Test
    public void testObserver() {
        logger.info("Starting Observer test ...");

        Person person = new Person();
        person.subscribe(args -> {
            logger.info("Age changed to:" + person.getAge());
            Assert.assertEquals(10, person.getAge());
        });
        person.setAge(10);
    }
}
