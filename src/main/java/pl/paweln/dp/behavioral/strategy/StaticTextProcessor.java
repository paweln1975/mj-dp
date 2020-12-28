package pl.paweln.dp.behavioral.strategy;

import java.util.List;
import java.util.function.Supplier;

public class StaticTextProcessor<T extends ListStrategy> {
    private StringBuilder stringBuilder = new StringBuilder();
    private T listStrategy;

    public StaticTextProcessor(Supplier<? extends T> supplier) {
        this.listStrategy = supplier.get();
    }

    public void appendList(List<String> stringList) {
        listStrategy.start(this.stringBuilder);
        for (String item:stringList) {
            listStrategy.addListItem(this.stringBuilder, item);
        }
        listStrategy.end(this.stringBuilder);
    }

    public void clear() {
        stringBuilder.setLength(0);
    }

    public String toString() {
        return this.stringBuilder.toString();
    }
}
