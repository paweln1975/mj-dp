package pl.paweln.dp.structural.flyweight;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest {
    private static Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void testUserCreation() {
        logger.info("User test ...");
        String john = "John";
        String smith = "Smith";
        String jenny = "Jenny";
        String kowalski = "Kowalski";
        String space = " ";
        User user1 = new User(john + space + smith);
        User user2 = new User(jenny + space + smith);
        User user3 = new User(kowalski);
        User user4 = new User(jenny + space + smith + space + kowalski);

        Assert.assertEquals(john, user1.getFirstName());
        Assert.assertEquals(smith, user1.getLastName());
        Assert.assertEquals(jenny, user2.getFirstName());
        Assert.assertEquals(smith, user2.getLastName());
        Assert.assertEquals(kowalski, user3.getFirstName());
        Assert.assertEquals("", user3.getLastName());
        Assert.assertEquals(jenny, user4.getFirstName());
        Assert.assertEquals(4, User.getNameCacheSize());
    }
}
