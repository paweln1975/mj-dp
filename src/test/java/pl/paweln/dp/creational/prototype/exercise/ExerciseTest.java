package pl.paweln.dp.creational.prototype.exercise;

import org.junit.Assert;
import org.junit.Test;


public class ExerciseTest {

    @Test
    public void testPointDeepCopy() {

        int startX = 10, startY = 15, endX = -4, endY = 80;
        int newStartX = 20, newStartY = 10, newEndX = -40, newEndY = 20;

        Line line = new Line(
                new Point(startX, startY),
                new Point(endX, endY)
        );

        Line newLine = line.deepCopy();
        newLine.start.x = newStartX;
        newLine.start.y = newStartY;
        newLine.end.x = newEndX;
        newLine.end.y = newEndY;

        Assert.assertEquals(startX, line.start.x);
        Assert.assertEquals(startY, line.start.y);
        Assert.assertEquals(endX, line.end.x);
        Assert.assertEquals(endY, line.end.y);

        Assert.assertEquals(newStartX, newLine.start.x);
        Assert.assertEquals(newStartY, newLine.start.y);
        Assert.assertEquals(newEndX, newLine.end.x);
        Assert.assertEquals(newEndY, newLine.end.y);



    }
}
