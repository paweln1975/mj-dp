package pl.paweln.dp.behavioral.iterator.array;

import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Creature implements Iterable<Integer> {
    private int[] stats = new int[3];

    public int getStrength() { return stats[0]; }
    public void setStrength(int value)
    {
        stats[0] = value;
    }

    public int getAgility() { return stats[1]; }
    public void setAgility(int value)
    {
        stats[1] = value;
    }

    public int getIntelligence() { return stats[2]; }
    public void setIntelligence(int value)
    {
        stats[2] = value;
    }

    public int sum() {
        return IntStream.of(stats).sum();
    }

    public int max() {
        OptionalInt max = IntStream.of(stats).max();
        if (max.isPresent()) {
            return max.getAsInt();
        } else {
            return 0;
        }
    }

    public double avg() {
        OptionalDouble average = IntStream.of(stats).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            return 0.0;
        }
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for(int x : stats) {
            action.accept(x);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return IntStream.of(stats).spliterator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.of(stats).iterator();
    }
}
