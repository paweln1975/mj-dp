package pl.paweln.dp.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Renderer {
    Logger logger = LoggerFactory.getLogger(Renderer.class);
    void renderCircle(float radius);
}
