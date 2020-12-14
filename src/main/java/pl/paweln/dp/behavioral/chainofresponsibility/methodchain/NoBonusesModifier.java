package pl.paweln.dp.behavioral.chainofresponsibility.methodchain;

public class NoBonusesModifier extends CreatureModifier {
    public NoBonusesModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        // empty
    }
}
