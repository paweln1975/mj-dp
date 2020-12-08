package pl.paweln.dp.structural.adapter.exercise;

public interface Rectangle {
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}
