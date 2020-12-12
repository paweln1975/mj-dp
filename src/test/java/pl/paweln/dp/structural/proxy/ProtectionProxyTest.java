package pl.paweln.dp.structural.proxy;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.proxy.protectionproxy.Car;
import pl.paweln.dp.structural.proxy.protectionproxy.CarProxy;
import pl.paweln.dp.structural.proxy.protectionproxy.Drivable;
import pl.paweln.dp.structural.proxy.protectionproxy.Driver;

public class ProtectionProxyTest {
    private static Logger logger = LoggerFactory.getLogger(ProtectionProxyTest.class);

    @Test
    public void testProtectionProxy() {
        int age = 10;
        Drivable car = new CarProxy(new Driver(age));
        String expectedForbidden = "THE CAR CANNOT BE DRIVEN BY DRIVER with AGE of " + age;

        Assert.assertEquals(expectedForbidden, car.drive());

        age = 20;
        String expectedOK = "The car is driven by a driver with age ";
        car = new CarProxy(new Driver(age));
        Assert.assertEquals(expectedOK  + age, car.drive());

        age = 12;
        car = new Car(new Driver(age));
        Assert.assertEquals(expectedOK  + age, car.drive());

    }
}
