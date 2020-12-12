package pl.paweln.dp.structural.facade;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class Console {
    private final int width;
    private final int height;
    private List<ViewPort> viewPortList = new ArrayList<>();

    public Console (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewPort(ViewPort viewPort) {
        this.viewPortList.add(viewPort);
    }

    public boolean render() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                for (ViewPort vp : viewPortList) {
                    System.out.print(vp.chatAt(x, y));
                }
            }
            System.out.println();
        }
        return true;
    }

    public static Console newConsole (int width, int height) {
        Buffer buffer = new Buffer(30, 20);
        ViewPort viewPort = new ViewPort(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewPort(viewPort);
        return console;
    }
}
