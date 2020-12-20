package pl.paweln.dp.behavioral.mediator;

import java.util.LinkedList;
import java.util.List;

public class Person implements MessageRecipient {

    private List<String> chatMessages = new LinkedList<>();

    private String name;

    private ChatRoom room;

    public void setChatRoom(ChatRoom room) {
        this.room = room;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getMessagesCount() {
        return chatMessages.size();
    }

    @Override
    public void receive(String sender, String message) {
        String msg = "[" + this.name   +"'s chat session] " + sender + ": '" + message +"'";
        this.chatMessages.add(msg);

        logger.info(msg);
    }

    public void say (String message) {
        this.room.broadcast(this.name, message);
    }

    public void privateMessage(String toWhom, String message) {
        this.room.message(this.name, toWhom, message);
    }
}
