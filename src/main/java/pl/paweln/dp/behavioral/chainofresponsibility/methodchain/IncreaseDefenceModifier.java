package pl.paweln.dp.behavioral.chainofresponsibility.methodchain;

public class IncreaseDefenceModifier extends CreatureModifier {
    public IncreaseDefenceModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        super.creature.setDefence(3 + creature.getDefence());
        super.handle();
    }
}
