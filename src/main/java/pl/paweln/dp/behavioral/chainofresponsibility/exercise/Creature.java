package pl.paweln.dp.behavioral.chainofresponsibility.exercise;

public abstract class Creature {

    protected final Game game;
    protected final int baseAttack;
    protected final int baseDefence;

    public Creature(Game game, int baseAttack, int baseDefence) {
        this.game = game;
        this.baseAttack = baseAttack;
        this.baseDefence = baseDefence;
    }

    public abstract int getAttack();
    public abstract int getDefense();
    public abstract void query(Object source, StatQuery sq);
}

