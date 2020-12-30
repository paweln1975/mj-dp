package pl.paweln.dp.behavioral.visitor.intrusive;

import pl.paweln.dp.behavioral.visitor.acyclic.AdditionExpressionVisitor;
import pl.paweln.dp.behavioral.visitor.acyclic.Visitor;
import pl.paweln.dp.behavioral.visitor.classic.ExpressionVisitor;

public class AdditionExpression extends Expression {
    public final Expression left, right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append("(");
        left.print(sb);
        sb.append("+");
        right.print(sb);
        sb.append(")");
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    // acyclic
    public void accept(Visitor visitor) {
        if (visitor instanceof AdditionExpressionVisitor)
            ((AdditionExpressionVisitor) visitor).visit(this);
    }
}
