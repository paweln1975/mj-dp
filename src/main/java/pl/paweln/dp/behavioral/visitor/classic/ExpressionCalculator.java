package pl.paweln.dp.behavioral.visitor.classic;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;

public class ExpressionCalculator implements ExpressionVisitor {

    public double result;

    @Override
    public void visit(DoubleExpression e) {
        result = e.value;
    }

    @Override
    public void visit(AdditionExpression ae) {
        ae.left.accept(this);
        double a = result;

        ae.right.accept(this);
        double b = result;

        result = a+b;
    }


}
