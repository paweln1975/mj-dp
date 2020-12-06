package pl.paweln.dp.creational.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.prototype.copyconstructor.Address;
import pl.paweln.dp.creational.prototype.copyconstructor.Employee;

public class PrototypeDemo {
    private static final Logger logger = LoggerFactory.getLogger(PrototypeDemo.class);

    public static void demo() {
        logger.info("Copy constructor demo ...");
        Employee employee = new Employee(new Address("London Road", "12345", "London"), "John");

        Employee employee2 = new Employee(employee);
        employee2.setName("Maria");
        employee2.getAddress().setPostalCode("54321");
        employee2.getAddress().setStreetName("London Eye Road");

        logger.info("Prototype:" + employee);
        logger.info("Copy:" + employee2);
    }
}
