package pl.paweln.dp.structural.proxy.protectionproxy;

public class CarProxy extends Car {
    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public String drive() {
        String s;
        if (driver.age >= 16) {
            return super.drive();
        } else {
            s = "THE CAR CANNOT BE DRIVEN BY DRIVER with AGE of " + driver.age;
            logger.info(s);
        }
        return s;
    }
}
