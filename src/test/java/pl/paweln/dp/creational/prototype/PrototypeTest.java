package pl.paweln.dp.creational.prototype;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.prototype.copyconstructor.Address;
import pl.paweln.dp.creational.prototype.copyconstructor.Employee;

public class PrototypeTest {
    private static final Logger logger = LoggerFactory.getLogger(PrototypeTest.class);

    @Test
    public void testCopyConstructor() {
        logger.info("Copy constructor demo ...");
        String streetAddress = "London Road";
        String streetAddressChanged = "London Eye Road";
        String postalCode = "12345";
        String postalCodeChanged = "54321";
        String name = "John";
        String nameChanged = "Maria";

        Employee employee = new Employee(new Address(streetAddress, postalCode, "London"), name);

        Employee employee2 = new Employee(employee);
        employee2.setName(nameChanged);
        employee2.getAddress().setPostalCode(postalCodeChanged);
        employee2.getAddress().setStreetName(streetAddressChanged);

        logger.info("Prototype:" + employee);
        Assert.assertEquals(name, employee.getName());
        Assert.assertEquals(postalCode, employee.getAddress().getPostalCode());
        Assert.assertEquals(streetAddress, employee.getAddress().getStreetName());

        logger.info("Copy:" + employee2);
        Assert.assertEquals(nameChanged, employee2.getName());
        Assert.assertEquals(postalCodeChanged, employee2.getAddress().getPostalCode());
        Assert.assertEquals(streetAddressChanged, employee2.getAddress().getStreetName());
    }
}
