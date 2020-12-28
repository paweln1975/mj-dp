package pl.paweln.dp.behavioral.strategy.exercise;

public class OrdinaryDiscriminantStrategy implements DiscriminantStrategy {
    @Override
    public double calculateDiscriminant(double a, double b, double c)
    {
        return calculate(a, b, c);
    }
}
