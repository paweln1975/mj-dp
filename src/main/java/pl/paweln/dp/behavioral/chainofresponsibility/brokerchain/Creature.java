package pl.paweln.dp.behavioral.chainofresponsibility.brokerchain;

public class Creature {
    private Game game;
    public String name;
    public int baseAttack, baseDefence;

    public Creature(Game game, String name, int baseAttack, int baseDefence) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefence = baseDefence;
    }

    public int getAttack() {
        Query query = new Query(this.name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(query);
        return query.result;
    }

    public int getDefence() {
        Query query = new Query(this.name, Query.Argument.DEFENCE, baseDefence);
        game.queries.fire(query);
        return query.result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + getAttack() +
                ", defence=" + getDefence() +
                '}';
    }
}
