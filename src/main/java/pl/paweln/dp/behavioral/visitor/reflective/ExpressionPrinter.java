package pl.paweln.dp.behavioral.visitor.reflective;

import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.Expression;

public class ExpressionPrinter {
    private ExpressionPrinter() {}

    public static void print (Expression e, StringBuilder stringBuilder) {
        if (e.getClass() == DoubleExpression.class) {
            stringBuilder.append(((DoubleExpression)e).value);
        } else if (e.getClass() == AdditionExpression.class) {
            AdditionExpression ae = (AdditionExpression) e;
            stringBuilder.append("(");
            ae.left.print(stringBuilder);
            stringBuilder.append("+");
            ae.right.print(stringBuilder);
            stringBuilder.append(")");
        }
    }
}
