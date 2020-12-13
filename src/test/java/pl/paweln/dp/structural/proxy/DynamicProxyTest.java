package pl.paweln.dp.structural.proxy;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.proxy.dynamicproxy.Human;
import pl.paweln.dp.structural.proxy.dynamicproxy.LoggingHandler;
import pl.paweln.dp.structural.proxy.dynamicproxy.Person;

public class DynamicProxyTest {
    private static Logger logger = LoggerFactory.getLogger(DynamicProxyTest.class);

    @Test
    public void testDynamicProxy() {
        logger.info("Dynamic proxy test ...");

        Human human = LoggingHandler.withLogging(new Person(), Human.class);
        human.walk();
        human.walk();
        human.talk();
        human.sleep(8);

        logger.info(human.toString());
        Assert.assertEquals("{sleep=1, talk=1, walk=2}", human.toString());

    }
}
