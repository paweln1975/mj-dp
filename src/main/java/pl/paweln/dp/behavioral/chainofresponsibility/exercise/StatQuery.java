package pl.paweln.dp.behavioral.chainofresponsibility.exercise;

public class StatQuery {
    protected Statistic statistic;
    public int result;

    public StatQuery(Statistic statistic) {
        this.statistic = statistic;
    }
}
