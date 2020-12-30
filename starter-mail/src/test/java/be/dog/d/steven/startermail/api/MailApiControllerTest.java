package be.dog.d.steven.startermail.api;

import be.dog.d.steven.startermail.mail.Mail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MailApiController.class})
@ExtendWith(SpringExtension.class)
public class MailApiControllerTest {
    @Autowired
    private MailApiController mailApiController;

    @Test
    public void testSendMail() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .delete("https://example.org/example", "foo", "foo", "foo")
                .contentType(MediaType.APPLICATION_JSON);
        Mail value = new Mail();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(value));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.mailApiController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

