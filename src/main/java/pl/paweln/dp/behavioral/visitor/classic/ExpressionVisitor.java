package pl.paweln.dp.behavioral.visitor.classic;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;

public interface ExpressionVisitor {
    // downsize of this approach - cyclic dependency between visitor and expressions
    void visit(DoubleExpression e);
    void visit(AdditionExpression ae);
}
