package pl.paweln.dp.structural.composite.arithmetic;

public abstract class ArithmeticOperand implements ArithmeticComposite {
    protected ArithmeticComposite left;
    protected ArithmeticComposite right;
    ArithmeticOperand(ArithmeticComposite p_left, ArithmeticComposite p_right) {
        this.left = p_left;
        this.right = p_right;
    }
}
