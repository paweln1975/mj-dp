package pl.paweln.dp.structural.bridge;

public class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        logger.info("Rendering vector circle with radius of " + radius);
    }
}
