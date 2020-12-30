package be.dog.d.steven.startermail.mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailTest {
    @Test
    public void testSetName() {
        Mail mail = new Mail();
        mail.setName("foo");
        assertEquals("foo", mail.getName());
    }

    @Test
    public void testSetEmail() {
        Mail mail = new Mail();
        mail.setEmail("jane.doe@example.org");
        assertEquals("jane.doe@example.org", mail.getEmail());
    }

    @Test
    public void testSetBody() {
        Mail mail = new Mail();
        mail.setBody("Not all who wander are lost");
        assertEquals("Not all who wander are lost", mail.getBody());
    }
}

