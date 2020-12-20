package pl.paweln.dp.behavioral.mediator.exercise;

public class Participant {
    public int value = 0;
    private Mediator mediator;

    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        this.mediator.join(this);
    }

    public void say(int n)
    {
        this.mediator.broadcast(this, n);
    }

    public void receive(Participant sender, int n) {
        if (sender != this)
            value += n;
    }
}
