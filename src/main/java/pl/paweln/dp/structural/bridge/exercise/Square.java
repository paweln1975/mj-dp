package pl.paweln.dp.structural.bridge.exercise;

public class Square extends Shape {
    @Override
    public String getName() {
        return "Square";
    }

    public Square (Renderer renderer) {
        super(renderer);
    }
}
