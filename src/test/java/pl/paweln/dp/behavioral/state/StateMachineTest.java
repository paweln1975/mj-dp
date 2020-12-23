package pl.paweln.dp.behavioral.state;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.state.machine.Machine;
import pl.paweln.dp.behavioral.state.machine.State;
import pl.paweln.dp.behavioral.state.machine.Trigger;

public class StateMachineTest {
    private static final Logger logger = LoggerFactory.getLogger(StateMachineTest.class);

    @Test
    public void testMachine() {
        Machine machine = new Machine();
        logger.info("Current state: " + machine.getCurrentState());

        machine.executeTrigger(Trigger.CALL_DIALED);
        logger.info("Current state: " + machine.getCurrentState());
        Assert.assertEquals(State.CONNECTING, machine.getCurrentState());

        machine.executeTrigger(Trigger.CALL_CONNECTED);
        logger.info("Current state: " + machine.getCurrentState());
        Assert.assertEquals(State.CONNECTED, machine.getCurrentState());

        machine.executeTrigger(Trigger.PLACED_ON_HOLD);
        logger.info("Current state: " + machine.getCurrentState());
        Assert.assertEquals(State.ON_HOLD, machine.getCurrentState());

        machine.executeTrigger(Trigger.TAKEN_OFF_HOLD);
        logger.info("Current state: " + machine.getCurrentState());
        Assert.assertEquals(State.CONNECTED, machine.getCurrentState());

        machine.executeTrigger(Trigger.HUNG_UP);
        logger.info("Current state: " + machine.getCurrentState());
        Assert.assertEquals(State.OFF_HOOK, machine.getCurrentState());


    }
}
