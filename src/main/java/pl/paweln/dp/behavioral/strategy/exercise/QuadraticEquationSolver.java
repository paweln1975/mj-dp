package pl.paweln.dp.behavioral.strategy.exercise;

public class QuadraticEquationSolver {
    private DiscriminantStrategy strategy;

    public QuadraticEquationSolver(DiscriminantStrategy strategy)
    {
        this.strategy = strategy;
    }

    public Pair<Complex, Complex> solve(double a, double b, double c)
    {
        return new Pair<>(new Complex(-b, 0)
                        .plus(Complex.sqrt(this.strategy.calculateDiscriminant(a, b, c)))
                        .divides(new Complex(2, 0))
                        .divides(new Complex(a, 0)),
                new Complex(-b, 0)
                        .minus(Complex.sqrt(this.strategy.calculateDiscriminant(a, b, c)))
                        .divides(new Complex(2, 0))
                        .divides(new Complex(a, 0)));
    }
}
