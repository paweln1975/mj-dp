package pl.paweln.dp.structural.adapter.exercise;

public class SquareToRectangleAdapter implements Rectangle {
    int width;
    int height;

    public SquareToRectangleAdapter(Square square)
    {
        this.width = square.side;
        this.height = square.side;
    }


    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
