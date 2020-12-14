package pl.paweln.dp.behavioral.chainofresponsibility.brokerchain;

public class IncreaseDefenceModifier extends CreatureModifier implements AutoCloseable {
    private final int token;

    public IncreaseDefenceModifier(Game game, Creature creature) {
        super(game, creature);

        token = game.queries.subscribe(query -> {
            if (query.creatureName.equals(creature.name) && query.argument == Query.Argument.DEFENCE) {
                query.result += 3;
            }
        });
    }

    @Override
    public void close() {
        game.queries.unsubscribe(token);
    }
}