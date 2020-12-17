package pl.paweln.dp.behavioral.interpreter;

public class IntegerValue implements Element {
    private int value;

    public IntegerValue(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }
}
