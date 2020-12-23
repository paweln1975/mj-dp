package pl.paweln.dp.behavioral.observer.exercise;
import java.io.Closeable;
import java.io.IOException;

public class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        this.game.event.subscribe(eventArgs -> {
            switch (eventArgs.getType()) {
                case ENTER:
                    if (!eventArgs.getSource().equals(this)) {
                        this.attack++;
                        this.game.event.fire(new EventArgs(eventArgs.getSource(), EventType.NOTIFY));
                    }
                    break;
                case NOTIFY:
                    if (eventArgs.getSource().equals(this)) {
                        this.attack++;
                    }
                    break;
                case DIED:
                    this.attack--;
                    break;
            }
            }
        );

        this.game.event.fire(new EventArgs(this, EventType.ENTER));
    }

    @Override
    public void close() throws IOException
    {
        this.game.event.fire(new EventArgs(this, EventType.DIED));
    }
}
