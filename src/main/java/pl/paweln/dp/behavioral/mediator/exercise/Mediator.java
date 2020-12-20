package pl.paweln.dp.behavioral.mediator.exercise;

import java.util.LinkedList;
import java.util.List;

public class Mediator {
    List<Participant> participants = new LinkedList<>();

    protected void join(Participant participant) {
        this.participants.add(participant);
    }

    protected void broadcast(Participant source, int n) {
        this.participants.stream()
                .filter(participant -> !participant.equals(source))
                .forEach(participant -> participant.receive(source, n));
    }
}
