package pl.paweln.dp.creational.builder.recursivegenerics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BuilderRecursiveGenericsDemo {
    private static final Logger logger = LoggerFactory.getLogger(BuilderRecursiveGenericsDemo.class);

    public static void demo() {

        logger.info("BuilderRecursiveGenericsDemo demo ...");

        Person.PersonBuilder builder1 = new Person.PersonBuilder<>();
        Person person = builder1
                .withName("Monika")
                .atAge(46)
                .build();
        logger.info("Created person: " + person);

        Person.EmployeeBuilder builder2 = new Person.EmployeeBuilder();
        person = builder2
                .withName("Pawel")
                .atAge(46)
                .worksAs("Manager")
                .build();

        logger.info("Created person: " + person);

    }
}
