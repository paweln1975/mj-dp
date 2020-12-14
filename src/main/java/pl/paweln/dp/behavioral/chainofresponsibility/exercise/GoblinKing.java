package pl.paweln.dp.behavioral.chainofresponsibility.exercise;

public class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game, 3, 3);
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source != this && sq.statistic==Statistic.ATTACK) {
            sq.result++;
        } else
            super.query(source, sq);
    }
}
