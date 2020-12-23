package pl.paweln.dp.behavioral.state;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateTest {
    private static final Logger logger = LoggerFactory.getLogger(StateTest.class);

    @Test
    public void testState() {
        logger.info("Starting State test ... ");
        LightSwitch ls = new LightSwitch();
        ls.on();
        ls.off();
        ls.off();

        Assert.assertTrue(ls.getState() instanceof OffState);

    }
}
