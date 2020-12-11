package pl.paweln.dp.structural.decorator;

public class MagicString {
    String string;

    public MagicString(String string) {
        this.string = string;
    }

    public long getNumberOfVowels()
    {
        return string.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> "aeiouąęó".contains(c.toString()))
                .count();
    }

    public int length() {
        return string.length();
    }

    public boolean isEmpty() {
        return string.isEmpty();
    }

    @Override
    public String toString() {
        return string;
    }
}
