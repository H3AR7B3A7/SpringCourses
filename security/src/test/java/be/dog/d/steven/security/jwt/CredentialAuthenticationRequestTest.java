package be.dog.d.steven.security.jwt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CredentialAuthenticationRequestTest {
    @Test
    public void testSetUsername() {
        CredentialAuthenticationRequest credentialAuthenticationRequest = new CredentialAuthenticationRequest();
        credentialAuthenticationRequest.setUsername("janedoe");
        assertEquals("janedoe", credentialAuthenticationRequest.getUsername());
    }

    @Test
    public void testSetPassword() {
        CredentialAuthenticationRequest credentialAuthenticationRequest = new CredentialAuthenticationRequest();
        credentialAuthenticationRequest.setPassword("iloveyou");
        assertEquals("iloveyou", credentialAuthenticationRequest.getPassword());
    }
}

