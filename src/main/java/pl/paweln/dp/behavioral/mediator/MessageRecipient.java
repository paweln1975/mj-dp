package pl.paweln.dp.behavioral.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MessageRecipient {
    Logger logger = LoggerFactory.getLogger(MessageRecipient.class);

    void receive(String sender, String message);

    String getName();

    void setChatRoom(ChatRoom room);

    long getMessagesCount();
}
