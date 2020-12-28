package pl.paweln.dp.behavioral.strategy.exercise;

public interface DiscriminantStrategy {
    double calculateDiscriminant(double a, double b, double c);

    default double calculate(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }
}
