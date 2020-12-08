package pl.paweln.dp.structural.composite.arithmetic;

public class NumericValue implements ArithmeticComposite {
    private int value;
    public NumericValue(int p_value) {
        this.value = p_value;
    }
    @Override
    public int getValue() {
        return this.value;
    }
}
