package pl.paweln.dp.creational.factory;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import pl.paweln.dp.creational.factory.exercise.Person;
import pl.paweln.dp.creational.factory.exercise.PersonFactory;

public class PersonFactoryTest {
    PersonFactory pf = new PersonFactory();

    @Test
    public void test() {
        Person p1 = pf.createPerson("Chris");
        assertEquals("Chris", p1.getName());
        assertEquals(0, p1.getId());

        Person p2 = pf.createPerson("Sarah");
        assertEquals(1, p2.getId());
    }
}
