package pl.paweln.dp.structural.composite.exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ExerciseTest {
    @Test
    public void testValueContainer() {
        SingleValue singleValue = new SingleValue(11);
        ManyValues otherValues = new ManyValues();
        otherValues.add(22);
        otherValues.add(33);
        Assert.assertEquals(66,
                new MyList(Arrays.asList(singleValue, otherValues)).sum());
    }
}
