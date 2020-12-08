package pl.paweln.dp.structural.adapter;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.structural.adapter.exercise.Rectangle;
import pl.paweln.dp.structural.adapter.exercise.Square;
import pl.paweln.dp.structural.adapter.exercise.SquareToRectangleAdapter;

public class ExerciseTest {
    @Test
    public void testSquareToRectangleAdapter() {
        Square square = new Square(10);
        Rectangle rectangle = new SquareToRectangleAdapter(square);

        Assert.assertEquals(square.side, rectangle.getHeight());
        Assert.assertEquals(square.side, rectangle.getWidth());

        Assert.assertEquals(100, rectangle.getArea());
    }
}
