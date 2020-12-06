package pl.paweln.dp.creational.factory;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.builder.BuilderTest;
import pl.paweln.dp.creational.factory.exercise.Person;
import pl.paweln.dp.creational.factory.exercise.PersonFactory;

public class PersonFactoryTest {
    private static final Logger logger = LoggerFactory.getLogger(PersonFactoryTest.class);

    PersonFactory pf = new PersonFactory();

    @Test
    public void test() {
        logger.info("Factory test ...");
        Person p1 = pf.createPerson("Chris");

        logger.info("Person created: " + p1);
        assertEquals("Chris", p1.getName());
        assertEquals(0, p1.getId());

        Person p2 = pf.createPerson("Sarah");

        logger.info("Person created: " + p2);
        assertEquals(1, p2.getId());
    }
}
