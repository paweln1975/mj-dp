package pl.paweln.dp.behavioral.interpreter;

public class BinaryOperation implements Element {
    public enum Type {
        ADDITION,
        SUBTRACTION
    }

    protected Element left;
    protected Element right;

    protected Type type;

    public BinaryOperation() {

    }

    @Override
    public int eval() {
        switch (this.type) {
            case ADDITION:
                return left.eval() + right.eval();
            case SUBTRACTION:
                return left.eval() - right.eval();
        }
        return 0;
    }
}
