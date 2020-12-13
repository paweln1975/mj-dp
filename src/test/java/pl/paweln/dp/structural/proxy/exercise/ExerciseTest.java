package pl.paweln.dp.structural.proxy.exercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExerciseTest {
    @Test
    public void test()
    {
        Person p = new Person(10);
        ResponsiblePerson rp = new ResponsiblePerson(p);

        assertEquals("too young", rp.drive());
        assertEquals("too young", rp.drink());
        assertEquals("dead", rp.drinkAndDrive());

        rp.setAge(20);

        assertEquals("driving", rp.drive());
        assertEquals("drinking", rp.drink());
        assertEquals("dead", rp.drinkAndDrive());
    }
}
