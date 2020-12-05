package pl.paweln.dp.creational.builder;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.creational.builder.exercise.CodeBuilder;

public class CodeBuilderTest {
    @Test
    public void testExercise() {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");

        String ls = System.lineSeparator();
        String expected = "public class Person" + ls +
                "{" + ls +
                "  public String name;" + ls +
                "  public int age;" + ls +
                "}";
        Assert.assertEquals(expected, cb.toString());
    }
}
