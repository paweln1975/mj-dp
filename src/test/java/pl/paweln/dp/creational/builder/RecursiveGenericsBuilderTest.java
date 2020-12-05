package pl.paweln.dp.creational.builder;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.creational.builder.recursivegenerics.FluentPerson;

public class RecursiveGenericsBuilderTest {
    FluentPerson.EmployeeBuilder builder = new FluentPerson.EmployeeBuilder();

    @Test
    public void testBuilder() {
        String name = "Pawel";
        int age = 46;
        String position = "Manager";

        String expected = "Person{name='" + name + "', age="+ age +", position='" + position +"'}";

        FluentPerson fluentPerson = builder
                .withName(name)
                .atAge(age)
                .worksAs(position)
                .build();

        Assert.assertEquals(expected, fluentPerson.toString());

    }
}
