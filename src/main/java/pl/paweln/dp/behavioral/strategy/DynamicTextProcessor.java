package pl.paweln.dp.behavioral.strategy;

import java.util.List;

public class DynamicTextProcessor {
    private StringBuilder stringBuilder = new StringBuilder();
    private ListStrategy listStrategy;

    public DynamicTextProcessor(OutputFormat format) {
        setOutputFormat(format);
    }

    public void setOutputFormat(OutputFormat format) {
        if (format == OutputFormat.MARKDOWN) {
            this.listStrategy = new MarkdownListStrategy();
        } else if (format == OutputFormat.HTML) {
            this.listStrategy = new HTMLListStrategy();
        }
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
