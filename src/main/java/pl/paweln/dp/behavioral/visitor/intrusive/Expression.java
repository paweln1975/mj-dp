package pl.paweln.dp.behavioral.visitor.intrusive;

import pl.paweln.dp.behavioral.visitor.acyclic.Visitor;
import pl.paweln.dp.behavioral.visitor.classic.ExpressionVisitor;

public abstract class Expression {
    // intrusive, reflective
    public abstract void print(StringBuilder sb);

    // double dispatch
    public abstract void accept(ExpressionVisitor visitor);

    // acyclic
    public void accept(Visitor visitor) {
        if (visitor instanceof pl.paweln.dp.behavioral.visitor.acyclic.ExpressionVisitor)
            ((pl.paweln.dp.behavioral.visitor.acyclic.ExpressionVisitor)visitor).visit(this);
    }
}
