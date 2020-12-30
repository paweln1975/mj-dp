package pl.paweln.dp.behavioral.visitor.intrusive;

import pl.paweln.dp.behavioral.visitor.acyclic.DoubleExpressionVisitor;
import pl.paweln.dp.behavioral.visitor.acyclic.Visitor;
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

    @Override
    // acyclic
    public void accept(Visitor visitor) {
        if (visitor instanceof DoubleExpressionVisitor)
            ((DoubleExpressionVisitor)visitor).visit(this);
    }


}
