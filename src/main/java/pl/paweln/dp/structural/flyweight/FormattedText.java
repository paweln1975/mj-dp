package pl.paweln.dp.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class FormattedText {
    private String plainText;

    private List<TextRange> formatting = new ArrayList<>();

    public FormattedText (String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange range = new TextRange(start, end);
        this.formatting.add(range);
        return range;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.plainText.length(); i++) {
            char c = this.plainText.charAt(i);
            for(TextRange range : formatting) {
                if (range.covers(i) && range.capitalize) {
                    c = Character.toUpperCase(c);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public class TextRange {
        private int start, end;

        // other flags may be added as well
        public boolean capitalize;


        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }
    }
}
