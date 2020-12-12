package pl.paweln.dp.structural.proxy.protectionproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Drivable {
    Logger logger = LoggerFactory.getLogger(Drivable.class);
    String drive();
}
