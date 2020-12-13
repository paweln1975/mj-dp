package pl.paweln.dp.structural.proxy.dynamicproxy;

public class Person implements Human {
    @Override
    public void walk() {
        logger.info("I'm walking");
    }

    @Override
    public void talk() {
        logger.info("I'm talking");
    }

    @Override
    public void sleep(int hours) {
        logger.info("I'm sleeping for " + hours + " hours");
    }
}
