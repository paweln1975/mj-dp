package pl.paweln.dp.behavioral.mediator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatRoomTest {
    private final static Logger logger = LoggerFactory.getLogger(ChatRoomTest.class);

    @Test
    public void testJoining() {
        logger.info("Staring ChatRoomTest 1 ...");
        MessageProcessor john = new Person("John");
        MessageProcessor jenny = new Person("Jenny");

        ChatRoom room = new ChatRoom("Meeting 1");
        room.join(john);
        room.join(jenny);

        Assert.assertEquals(2, john.getMessagesCount());
        Assert.assertEquals(1, jenny.getMessagesCount());
    }

    @Test
    public void testLeaving() {
        logger.info("Staring ChatRoomTest 2 ...");
        MessageProcessor john = new Person("John");
        MessageProcessor jenny = new Person("Jenny");

        ChatRoom room = new ChatRoom("Meeting 2");
        room.join(john);
        room.join(jenny);

        room.leave(john);

        Assert.assertEquals(3, john.getMessagesCount());
        Assert.assertEquals(2, jenny.getMessagesCount());
    }

    @Test
    public void testMessaging() {
        logger.info("Staring ChatRoomTest 3 ...");
        MessageProcessor john = new Person("John");
        MessageProcessor jenny = new Person("Jenny");
        MessageProcessor simon = new Person("Simon");

        ChatRoom room = new ChatRoom("Meeting 3");
        room.join(john);
        room.join(jenny);

        john.say("Hello " + jenny.getName());
        john.privateMessage(jenny.getName(), "How are you?");

        room.join(simon);
        john.say("Hello everyone");

        Assert.assertEquals(3, john.getMessagesCount());
        Assert.assertEquals(5, jenny.getMessagesCount());
        Assert.assertEquals(2, simon.getMessagesCount());

    }
}
