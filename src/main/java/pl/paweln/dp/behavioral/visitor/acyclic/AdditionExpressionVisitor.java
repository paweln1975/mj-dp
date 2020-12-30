package pl.paweln.dp.behavioral.visitor.acyclic;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;

public interface AdditionExpressionVisitor extends Visitor {
    void visit(AdditionExpression obj);
}
