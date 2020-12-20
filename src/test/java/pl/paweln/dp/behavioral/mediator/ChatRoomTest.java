package pl.paweln.dp.behavioral.mediator;

import org.junit.Assert;
import org.junit.Test;

public class ChatRoomTest {
    @Test
    public void testJoining() {
        MessageRecipient john = new Person("John");
        MessageRecipient jenny = new Person("Jenny");

        ChatRoom room = new ChatRoom("Meeting 1");
        room.join(john);
        room.join(jenny);

        Assert.assertEquals(2, john.getMessagesCount());
        Assert.assertEquals(1, jenny.getMessagesCount());
    }

    @Test
    public void testLeaving() {
        MessageRecipient john = new Person("John");
        MessageRecipient jenny = new Person("Jenny");

        ChatRoom room = new ChatRoom("Meeting 2");
        room.join(john);
        room.join(jenny);

        room.leave(john);

        Assert.assertEquals(3, john.getMessagesCount());
        Assert.assertEquals(2, jenny.getMessagesCount());
    }

    @Test
    public void testMessaging() {
        MessageRecipient john = new Person("John");
        MessageRecipient jenny = new Person("Jenny");
        MessageRecipient simon = new Person("Simon");

        ChatRoom room = new ChatRoom("Meeting 3");
        room.join(john);
        room.join(jenny);

        Person p = (Person) john;
        p.say("Hello " + jenny.getName());

        p.privateMessage(jenny.getName(), "How are you?");

        room.join(simon);

        p.say("Hello everyone");

        Assert.assertEquals(3, john.getMessagesCount());
        Assert.assertEquals(5, jenny.getMessagesCount());
        Assert.assertEquals(2, simon.getMessagesCount());

    }
}
