package pl.paweln.dp.structural.facade;

public class ViewPort {

    private final Buffer buffer;
    private final int width;
    private final int height;
    private final int offsetX;
    private final int offsetY;

    public ViewPort(Buffer buffer, int width, int height, int offsetX, int offsetY) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public char chatAt(int x, int y) {
        return buffer.charAt(x+offsetX, y + offsetY);
    }
}
