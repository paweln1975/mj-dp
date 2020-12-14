package pl.paweln.dp.behavioral.chainofresponsibility.methodchain;

public class DoubleAttackModifier extends CreatureModifier {
    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        super.creature.setAttack(2 * creature.getAttack());
        super.handle();
    }
}
