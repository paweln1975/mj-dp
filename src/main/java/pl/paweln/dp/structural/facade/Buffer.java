package pl.paweln.dp.structural.facade;

import java.io.CharArrayWriter;

public class Buffer {
    private char [] characters;
    private int lineWidth;

    public Buffer(int lineHeight, int lineWidth) {
        this.characters = new char[lineHeight*lineHeight];
        this.lineWidth = lineWidth;
    }

    public char charAt(int x, int y) {
        return characters[y*lineWidth+x];
    }
}
