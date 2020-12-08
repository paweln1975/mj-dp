package pl.paweln.dp.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PointDrawerImpl implements PointDrawer {
    private static final Logger logger = LoggerFactory.getLogger(PointDrawer.class);
    @Override
    public void draw(Point p) {
        logger.info("Point draw(): " + p.toString());
    }
}
