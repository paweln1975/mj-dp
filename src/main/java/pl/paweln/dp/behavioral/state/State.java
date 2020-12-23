package pl.paweln.dp.behavioral.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class State {
    protected static final Logger logger = LoggerFactory.getLogger(State.class);

    void on (LightSwitch ls) {
        logger.info("Light is already on");
    }
    void off (LightSwitch ls) {
        logger.info("Light is already off");
    }

}
