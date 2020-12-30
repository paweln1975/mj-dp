package pl.paweln.dp.behavioral.visitor.acyclic;

import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;

public interface DoubleExpressionVisitor extends Visitor {
    void visit(DoubleExpression obj);
}
