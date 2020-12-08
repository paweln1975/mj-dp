package pl.paweln.dp.structural.composite.exercise;
import java.util.ArrayList;
import java.util.Collection;

public class MyList extends ArrayList<ValueContainer>
{
// please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        int result = 0;
        for (ValueContainer valueContainer : this) {
            for (Integer value : valueContainer) {
                result += value;
            }
        }
        return result;
    }
}
