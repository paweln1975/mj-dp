package pl.paweln.dp.behavioral.visitor.exercise;

public abstract class Expression {
    abstract void accept(ExpressionVisitor ev);
}
