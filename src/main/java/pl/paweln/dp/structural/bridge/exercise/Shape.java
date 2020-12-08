package pl.paweln.dp.structural.bridge.exercise;

public abstract class Shape {
    private Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return "Drawing " + getName() + " as " + renderer.whatToRenderAs();
    }
}
