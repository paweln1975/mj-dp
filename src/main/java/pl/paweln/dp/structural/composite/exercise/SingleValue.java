package pl.paweln.dp.structural.composite.exercise;

import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}
