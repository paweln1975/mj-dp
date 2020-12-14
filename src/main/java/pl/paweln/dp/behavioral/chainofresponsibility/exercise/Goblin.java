package pl.paweln.dp.behavioral.chainofresponsibility.exercise;


public class Goblin extends Creature {
    protected Goblin (Game game, int baseAttack, int baseDefence) {
        super(game, baseAttack, baseDefence);
    }

    public Goblin(Game game) {
        super(game, 1, 1);
    }

    @Override
    public int getAttack() {
        StatQuery query = new StatQuery(Statistic.ATTACK);
        for(Creature creature : game.creatures) {
            creature.query(this, query);
        }
        return query.result;
    }

    @Override
    public int getDefense() {
        StatQuery query = new StatQuery(Statistic.DEFENCE);
        for (Creature creature : game.creatures) {
            creature.query(this, query);
        }
        return query.result;
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source == this) {
            if (sq.statistic == Statistic.ATTACK) {
                sq.result += super.baseAttack;
            } else if (sq.statistic == Statistic.DEFENCE) {
                sq.result += super.baseDefence;
            }
        } else if (sq.statistic == Statistic.DEFENCE) {
            sq.result++;
        }
    }
}

