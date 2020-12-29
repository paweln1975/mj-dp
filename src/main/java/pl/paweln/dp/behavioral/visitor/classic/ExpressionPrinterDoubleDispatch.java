package pl.paweln.dp.behavioral.visitor.classic;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;

public class ExpressionPrinterDoubleDispatch implements ExpressionVisitor {

    StringBuilder builder = new StringBuilder();

    @Override
    public void visit(DoubleExpression e) {
        builder.append(e.value);
    }

    @Override
    public void visit(AdditionExpression ae) {
        builder.append("(");
        ae.left.accept(this);
        builder.append("+");
        ae.right.accept(this);
        builder.append(")");
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
