package pl.paweln.dp.structural.decorator.dynamiccomposition;

public class Circle implements Shape {
    float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public void resize(float factor) {
        this.radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of a radius " + radius;
    }
}
