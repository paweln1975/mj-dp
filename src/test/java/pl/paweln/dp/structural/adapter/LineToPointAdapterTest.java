package pl.paweln.dp.structural.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LineToPointAdapterTest {
    private static Logger logger = LoggerFactory.getLogger(LineToPointAdapterTest.class);
    @Test
    public void testLineToPointAdapterNoCache() {
        logger.info("Adapter with no cache test ...");
        Line line = new Line(new Point(0, 0), new Point(0, 5));
        LineToPointAdapter adapter = new LineToPointAdapter(line);

        PointDrawer drawer = new PointDrawerImpl();
        adapter.forEach(drawer::draw);

        Assert.assertEquals(6, adapter.size());

        line = new Line(new Point(0, 0), new Point(10, 0));
        adapter = new LineToPointAdapter(line);

        Assert.assertEquals(11, adapter.size());

        line = new Line(new Point(0, 0), new Point(10, 10));
        adapter = new LineToPointAdapter(line);

        Assert.assertEquals(0, adapter.size());
    }

    @Test
    public void testLineToPointAdapterCached() {
        logger.info("Adapter with cache test ...");
        Line line1 = new Line(new Point(15, 15), new Point(15, 19));
        Line line2 = new Line(new Point(15, 15), new Point(15, 19));

        LineToPointAdapterCached adapter1 = new LineToPointAdapterCached(line1);
        LineToPointAdapterCached adapter2 = new LineToPointAdapterCached(line2);

        PointDrawer drawer = new PointDrawerImpl();
        adapter1.forEach(drawer::draw);
        adapter2.forEach(drawer::draw);

        Assert.assertEquals(1, LineToPointAdapterCached.getCacheSize());

    }
}
