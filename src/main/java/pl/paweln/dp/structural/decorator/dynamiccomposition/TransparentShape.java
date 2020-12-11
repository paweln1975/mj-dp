package pl.paweln.dp.structural.decorator.dynamiccomposition;

public class TransparentShape implements Shape {
    Shape shape;
    int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.transparency = transparency;
        this.shape = shape;
    }

    @Override
    public String info() {
        return this.shape.info() + " has transparency of " + transparency + "%";
    }
}
