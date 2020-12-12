package pl.paweln.dp.structural.proxy.protectionproxy;

public class Car implements Drivable {
    protected Driver driver;

    public Car (Driver driver) {
        this.driver = driver;
    }

    @Override
    public String drive() {
        String s = "The car is driven by a driver with age " + this.driver.age;
        logger.info(s);
        return s;
    }
}
