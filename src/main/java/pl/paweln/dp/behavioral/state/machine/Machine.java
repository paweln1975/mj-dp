package pl.paweln.dp.behavioral.state.machine;


import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Machine {
    private static Map<State, List<Pair<Trigger, State>>> rules =
        new EnumMap<>(State.class);

    static {
        rules.put(State.OFF_HOOK, Arrays.asList(
                Pair.of(Trigger.CALL_DIALED, State.CONNECTING),
                Pair.of(Trigger.STOP_USING_PHONE, State.ON_HOOK)));

        rules.put(State.CONNECTING, Arrays.asList(
                Pair.of(Trigger.HUNG_UP, State.OFF_HOOK),
                Pair.of(Trigger.CALL_CONNECTED, State.CONNECTED)));

        rules.put(State.CONNECTED, Arrays.asList(
                Pair.of(Trigger.LEFT_MESSAGE, State.OFF_HOOK),
                Pair.of(Trigger.HUNG_UP, State.OFF_HOOK),
                Pair.of(Trigger.PLACED_ON_HOLD, State.ON_HOLD)));

        rules.put(State.ON_HOLD, Arrays.asList(
                Pair.of(Trigger.TAKEN_OFF_HOLD, State.CONNECTED),
                Pair.of(Trigger.HUNG_UP, State.OFF_HOOK)));
    }

    private State currentState = State.OFF_HOOK;

    public State getCurrentState() {
        return this.currentState;
    }

    public void executeTrigger(Trigger trigger) {
        List<Pair<Trigger, State>> list = rules.get(this.currentState);

        boolean found = false;

        if (list != null) {
            for (Pair<Trigger, State> pair : list) {
                if (pair.getLeft() == trigger) {
                    this.currentState = pair.getRight();
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            throw new IllegalStateException("State not available");
        }
    }
}
