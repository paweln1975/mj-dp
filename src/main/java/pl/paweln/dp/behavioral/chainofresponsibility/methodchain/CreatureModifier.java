package pl.paweln.dp.behavioral.chainofresponsibility.methodchain;

public class CreatureModifier {
    protected Creature creature;
    private CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void add(CreatureModifier cm) {
        if (this.next != null) {
            next.add(cm);
        } else {
            next = cm;
        }
    }

    public void handle() {
        if (this.next != null) next.handle();
    }
}
