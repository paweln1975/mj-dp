package pl.paweln.dp.behavioral.visitor.acyclic;

import pl.paweln.dp.behavioral.visitor.intrusive.Expression;

public interface ExpressionVisitor extends Visitor {
    void visit(Expression obj);
}
