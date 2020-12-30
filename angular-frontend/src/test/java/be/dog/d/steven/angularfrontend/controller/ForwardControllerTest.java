package be.dog.d.steven.angularfrontend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ForwardController.class})
@ExtendWith(SpringExtension.class)
public class ForwardControllerTest {
    @Autowired
    private ForwardController forwardController;

    @Test
    public void testFrontend() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/index");
        MockMvcBuilders.standaloneSetup(this.forwardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("forward:/"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/"));
    }

    @Test
    public void testFrontend2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/index", "uriVars");
        MockMvcBuilders.standaloneSetup(this.forwardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("forward:/"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/"));
    }
}

