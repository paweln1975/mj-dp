package pl.paweln.dp.behavioral.mediator;

import java.util.LinkedList;
import java.util.List;

public class ChatRoom {
    private String name;

    public ChatRoom(String name) {
        this.name = name;
    }

    private List<MessageRecipient> members = new LinkedList<>();

    public void join(MessageRecipient member) {
        if (!this.members.contains(member)) {
            this.members.add(member);
            member.setChatRoom(this);
            this.broadcast("Room:" + name, member.getName() + " has joined the room");
        }
    }

    public void leave (MessageRecipient member) {
        if (this.members.contains(member)) {
            this.broadcast("Room:" + name, member.getName() + " has left the room");
            this.members.remove(member);
            member.setChatRoom(null);
        }
    }

    public void broadcast (String source, String message) {
        this.members.stream()
                .filter(r -> !r.getName().equals(source))
                .forEach(r -> r.receive(source, message));
    }

    public void message(String source, String destination, String message) {
        this.members.stream()
                .filter(r -> r.getName().equals(destination))
                .findFirst()
                .ifPresent(r -> r.receive(source, message));
    }
}
