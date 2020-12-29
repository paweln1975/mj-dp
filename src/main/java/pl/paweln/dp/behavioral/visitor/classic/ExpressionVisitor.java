package pl.paweln.dp.behavioral.visitor.classic;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;

public interface ExpressionVisitor {
    void visit(DoubleExpression e);
    void visit(AdditionExpression ae);
}
