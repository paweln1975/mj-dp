package pl.paweln.dp.behavioral.nullobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputLog implements Log {
    private static final Logger logger = LoggerFactory.getLogger(OutputLog.class);


    @Override
    public void debug(String s) {
        logger.debug(s);
    }

    @Override
    public void info(String s) {
        logger.info(s);
    }
}
