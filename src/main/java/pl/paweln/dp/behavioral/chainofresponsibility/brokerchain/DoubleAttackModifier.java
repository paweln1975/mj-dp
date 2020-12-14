package pl.paweln.dp.behavioral.chainofresponsibility.brokerchain;

public class DoubleAttackModifier extends CreatureModifier implements AutoCloseable {
    private final int token;

    public DoubleAttackModifier(Game game, Creature creature) {
        super(game, creature);

        token = game.queries.subscribe(query -> {
            if (query.creatureName.equals(creature.name) && query.argument == Query.Argument.ATTACK) {
                query.result *= 2;
            }
        });
    }

    @Override
    public void close() {
        game.queries.unsubscribe(token);
    }
}
