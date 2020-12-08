package pl.paweln.dp.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Consumer;

public class LineToPointAdapterCached implements Iterable<Point> {
    private static final Logger logger = LoggerFactory.getLogger(LineToPointAdapterCached.class);
    private static int count = 0;
    private static Map<Integer, List<Point>> cache = new HashMap<>();
    private int hash;

    public LineToPointAdapterCached(Line line ) {
        logger.info(
                String.format("%d: Generating points for line [%d,%d]-[%d,%d] (with caching)",
                        ++count, line.start.x, line.start.y, line.end.x, line.end.y));

        hash = line.hashCode();
        if (cache.get(hash) != null) return;

        ArrayList<Point> points = new ArrayList<>();

        int left = Math.min(line.start.x, line.end.x);
        int right = Math.max(line.start.x, line.end.x);
        int top = Math.min(line.start.y, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.y - line.start.y;

        if (dx == 0)
        {
            for (int y = top; y <= bottom; ++y)
            {
                points.add(new Point(left, y));
            }
        }
        else if (dy == 0)
        {
            for (int x = left; x <= right; ++x)
            {
                points.add(new Point(x, top));
            }
        }
        cache.put(hash, points);
    }

    public static int getCacheSize() {
        return cache.size();
    }
    @Override
    public Iterator<Point> iterator() {
        return cache.get(hash).iterator();
    }

    @Override
    public void forEach(Consumer<? super Point> action) {
        cache.get(hash).forEach(action);
    }

    @Override
    public Spliterator<Point> spliterator() {
        return cache.get(hash).spliterator();
    }
}
