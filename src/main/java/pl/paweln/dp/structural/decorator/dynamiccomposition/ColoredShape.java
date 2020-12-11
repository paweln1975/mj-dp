package pl.paweln.dp.structural.decorator.dynamiccomposition;

public class ColoredShape implements Shape {
    Shape shape;
    String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return this.shape.info() + " has the color " + color;
    }
}
