package be.dog.d.steven.startermail.mail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {MailConfiguration.class})
@ExtendWith(SpringExtension.class)
public class MailConfigurationTest {
    @Autowired
    private MailConfiguration mailConfiguration;

    @Test
    public void testCanEqual() {
        assertFalse(this.mailConfiguration.canEqual("other"));
        assertTrue(this.mailConfiguration.canEqual(this.mailConfiguration));
    }

    @Test
    public void testEquals() {
        assertFalse(this.mailConfiguration.equals("o"));
        assertTrue(this.mailConfiguration.equals(this.mailConfiguration));
        assertFalse(this.mailConfiguration.equals(new MailConfiguration()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1845967427, this.mailConfiguration.hashCode());
    }

    @Test
    public void testSetHost() {
        this.mailConfiguration.setHost("localhost");
        assertEquals("localhost", this.mailConfiguration.getHost());
    }

    @Test
    public void testSetPassword() {
        this.mailConfiguration.setPassword("iloveyou");
        assertEquals("iloveyou", this.mailConfiguration.getPassword());
    }

    @Test
    public void testSetPort() {
        this.mailConfiguration.setPort(8080);
        assertEquals(8080, this.mailConfiguration.getPort());
    }

    @Test
    public void testSetUsername() {
        this.mailConfiguration.setUsername("janedoe");
        assertEquals("janedoe", this.mailConfiguration.getUsername());
    }

    @Test
    public void testToString() {
        assertEquals("MailConfiguration(host=localhost, port=8080, username=janedoe, password=iloveyou)",
                this.mailConfiguration.toString());
    }
}

