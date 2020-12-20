package pl.paweln.dp.behavioral.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MessageProcessor {
    Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

    void receive(String sender, String message);

    String getName();

    void setChatRoom(ChatRoom room);

    long getMessagesCount();

    void say (String message);

    void privateMessage(String toWhom, String message);
}
