package pl.paweln.dp.structural.bridge;

import com.google.inject.Inject;

public class Circle extends Shape {
    private int radius;

    @Inject
    public Circle(Renderer renderer) {
        super((renderer));
    }

    public Circle(Renderer renderer, int radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        this.renderer.renderCircle(this.radius);
    }

    @Override
    public void resize(int factor) {
        this.radius = factor * this.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
