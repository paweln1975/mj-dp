package pl.paweln.dp.behavioral.visitor.acyclic;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;

public class AcyclicExpressionPrinter implements DoubleExpressionVisitor, AdditionExpressionVisitor {
    StringBuilder builder = new StringBuilder();

    @Override
    public void visit(AdditionExpression obj) {
        builder.append("(");
        obj.left.accept(this);
        builder.append("+");
        obj.right.accept(this);
        builder.append(")");
    }

    @Override
    public void visit(DoubleExpression obj) {
        builder.append(obj.value);
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
