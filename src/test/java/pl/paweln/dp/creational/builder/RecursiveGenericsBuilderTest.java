package pl.paweln.dp.creational.builder;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.builder.recursivegenerics.Person;

public class RecursiveGenericsBuilderTest {
    private static final Logger logger = LoggerFactory.getLogger(RecursiveGenericsBuilderTest.class);

    Person.PersonBuilder personBuilder = new Person.PersonBuilder<>();
    Person.EmployeeBuilder employeeBuilder = new Person.EmployeeBuilder();

    @Test
    public void testEmployeeBuilder() {
        logger.info("Recursive Generics Employee Builder test ...");

        String name = "Pawel";
        int age = 46;
        String position = "Manager";

        String expected = "Person{name='" + name + "', age="+ age +", position='" + position +"'}";

        Person person = employeeBuilder
                .withName(name)
                .atAge(age)
                .worksAs(position)
                .build();

        logger.info("Person: " + person.toString());
        Assert.assertEquals(expected, person.toString());


    }

    @Test
    public void testPersonBuilder() {
        logger.info("Recursive Generics Person Builder test ...");

        String name = "Pawel";
        int age = 46;

        String expected = "Person{name='" + name + "', age="+ age + ", position='null'}";

        Person person = this.personBuilder
                .withName(name)
                .atAge(46)
                .build();

        logger.info("Person: " + person.toString());
        Assert.assertEquals(expected, person.toString());

    }

}
