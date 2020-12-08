package pl.paweln.dp.structural.composite.neurons;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;
import java.util.function.Consumer;

public class Neuron implements SomeNeurons {
    public List<Neuron> in = new ArrayList<>();
    public List<Neuron> out = new ArrayList<>();

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }
}
