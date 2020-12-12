package pl.paweln.dp.creational.builder.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseTest {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseTest.class);


    @Test
    public void testCodeBuilder() {
        logger.info("Code Builder test ...");

        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");

        String ls = System.lineSeparator();
        String expected = "public class Person" + ls +
                "{" + ls +
                "  public String name;" + ls +
                "  public int age;" + ls +
                "}";

        logger.info("Generated code: " + cb);
        Assert.assertEquals(expected, cb.toString());
    }
}
