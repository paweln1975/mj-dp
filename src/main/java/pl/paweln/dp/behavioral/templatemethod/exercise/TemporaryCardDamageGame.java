package pl.paweln.dp.behavioral.templatemethod.exercise;

public class TemporaryCardDamageGame extends CardGame {
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        int tmp = other.health;
        other.health -= attacker.attack;
        if (other.health > 0)
            other.health = tmp;
    }


}
