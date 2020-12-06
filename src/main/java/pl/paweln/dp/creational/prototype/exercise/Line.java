package pl.paweln.dp.creational.prototype.exercise;

public class Line
{
        public Point start, end;

        public Line(Point start, Point end)
        {
            this.start = start;
            this.end = end;
        }

        public Line deepCopy()
        {
            return new Line(new Point(this.start), new Point(this.end));
        }
}

