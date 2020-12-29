package pl.paweln.dp.behavioral.visitor.intrusive;

import pl.paweln.dp.behavioral.visitor.classic.ExpressionVisitor;

public abstract class Expression {
    public abstract void print(StringBuilder sb);

    public abstract void accept(ExpressionVisitor visitor);
}
