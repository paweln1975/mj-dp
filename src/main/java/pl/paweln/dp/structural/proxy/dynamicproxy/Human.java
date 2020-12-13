package pl.paweln.dp.structural.proxy.dynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Human {
    Logger logger = LoggerFactory.getLogger(Human.class);
    void walk();
    void talk();
    void sleep(int hours);
}
