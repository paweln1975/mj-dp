package pl.paweln.dp.behavioral.visitor.intrusive;

import pl.paweln.dp.behavioral.visitor.classic.ExpressionVisitor;

public class DoubleExpression extends Expression {
    public double value;

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append(this.value);
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }


}
