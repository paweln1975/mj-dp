package pl.paweln.dp.behavioral.strategy.exercise;

public class RealDiscriminantStrategy implements DiscriminantStrategy{
    @Override
    public double calculateDiscriminant(double a, double b, double c)
    {
        double val = calculate(a, b, c);
        if (val < 0) {
            return Double.NaN;
        }
        return val;
    }
}
