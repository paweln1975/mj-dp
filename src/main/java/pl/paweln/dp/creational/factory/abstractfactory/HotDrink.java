package pl.paweln.dp.creational.factory.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface HotDrink {
    Logger logger = LoggerFactory.getLogger(HotDrink.class);
    String consume();
}
