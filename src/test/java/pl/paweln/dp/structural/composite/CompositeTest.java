package pl.paweln.dp.structural.composite;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeTest {
    private static Logger logger = LoggerFactory.getLogger(CompositeTest.class);

    @Test
    public void testGraphicObject() {
        String ls = System.lineSeparator();
        String expected =
                "My Drawing" + ls +
                        "* Red Square" + ls +
                        "* Yellow Circle" + ls +
                        "* Group" + ls +
                        "** Blue Circle" + ls +
                        "** Blue Square" + ls;

        GraphicObject drawing = new GraphicObject();

        drawing.setName("My Drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);

        Assert.assertEquals(expected, drawing.toString());
    }
}
