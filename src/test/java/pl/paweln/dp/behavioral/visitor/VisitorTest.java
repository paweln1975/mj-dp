package pl.paweln.dp.behavioral.visitor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.visitor.acyclic.AcyclicExpressionPrinter;
import pl.paweln.dp.behavioral.visitor.classic.ExpressionCalculator;
import pl.paweln.dp.behavioral.visitor.classic.ExpressionPrinterDoubleDispatch;
import pl.paweln.dp.behavioral.visitor.intrusive.AdditionExpression;
import pl.paweln.dp.behavioral.visitor.intrusive.DoubleExpression;
import pl.paweln.dp.behavioral.visitor.reflective.ExpressionPrinter;

public class VisitorTest {
    private static final Logger logger = LoggerFactory.getLogger(VisitorTest.class);
    String expExpr;
    AdditionExpression e;

    @Before
    public void setUp() {
        expExpr = "(1.0+(2.0+3.0))";
        e = new AdditionExpression(
                new DoubleExpression(1),
                new AdditionExpression(
                        new DoubleExpression(2),
                        new DoubleExpression(3)
                )
        );
    }

    @Test
    public void testIntrusiveVisitor() {
        // violation of OCP
        logger.info("Start the Intrusive Visitor test ...");
        StringBuilder sb = new StringBuilder();
        e.print(sb);
        logger.info("Expression: " + sb );
        Assert.assertEquals(expExpr, sb.toString());
    }

    @Test
    public void testReflectiveVisitor() {
        // this code is pretty slow, we've lost verification the every type of expression/case is covered
        logger.info("Start the Reflective Visitor test ...");
        StringBuilder sb = new StringBuilder();
        ExpressionPrinter.print(e, sb);
        logger.info("Expression: " + sb );
        Assert.assertEquals(expExpr, sb.toString());
    }

    @Test
    public void testDoubleDispatchVisitor() {
        logger.info("Start the Double Dispatch Visitor test ...");
        ExpressionPrinterDoubleDispatch printer = new ExpressionPrinterDoubleDispatch();
        printer.visit(e);
        logger.info("Expression: " + printer.toString());
        Assert.assertEquals(expExpr, printer.toString());
    }

    @Test
    public void testExpressionCalculator() {
        // uses double dispatch approach
        logger.info("Start Expression Calculator test ...");
        ExpressionCalculator calc = new ExpressionCalculator();
        calc.visit(e);
        logger.info("Result: " + calc.result);

        Assert.assertEquals(6, calc.result, 0);
    }

    @Test
    public void testAcyclicVisitor() {
        // uses double dispatch approach
        logger.info("Start Acyclic Visitor test ...");
        AcyclicExpressionPrinter printer = new AcyclicExpressionPrinter();
        printer.visit(e);
        logger.info("Expression: " + printer.toString());
        Assert.assertEquals(expExpr, printer.toString());
    }


}
