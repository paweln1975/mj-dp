package pl.paweln.dp.structural.composite.arithmetic;

public class MinusOperand extends ArithmeticOperand {
    public MinusOperand(ArithmeticComposite left, ArithmeticComposite right) {
        super(left, right);
    }


    @Override
    public int getValue() {
        return super.left.getValue() - super.right.getValue();
    }
}
