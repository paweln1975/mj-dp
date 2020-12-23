package pl.paweln.dp.behavioral.state.machine;

public enum State {
    OFF_HOOK, // starting
    ON_HOOK, // terminal state
    CONNECTING,
    CONNECTED,
    ON_HOLD
}
