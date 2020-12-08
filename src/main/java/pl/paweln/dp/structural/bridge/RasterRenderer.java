package pl.paweln.dp.structural.bridge;

public class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        logger.info("Rendering raster circle with radius of " + radius);
    }
}
