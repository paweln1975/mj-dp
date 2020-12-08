package pl.paweln.dp.structural.bridge.exercise;

public class Triangle extends Shape {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public Triangle (Renderer renderer) {
        super(renderer);
    }
}
