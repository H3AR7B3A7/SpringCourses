package be.dog.d.steven.angularfrontend.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
public class BookControllerTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testGetBooks() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "[{\"id\":1,\"name\":\"Beginning programming with C++ for dummies\",\"author\":\"Stephen R. Davis\"},{\"id\":2,"
                                        + "\"name\":\"Learning Python\",\"author\":\"Mark Lutz\"},{\"id\":3,\"name\":\"Domain Driven Design\",\"author\":\"Eric"
                                        + " Evans\"},{\"id\":4,\"name\":\"Agile Project Management for dummies\",\"author\":\"Mark C. Layton\"},{\"id\":5,"
                                        + "\"name\":\"Scrum for dummies\",\"author\":\"Mark C. Layton\"},{\"id\":6,\"name\":\"Java Design Patterns\",\"author\""
                                        + ":\"Vaskaran Sarcar\"},{\"id\":7,\"name\":\"Pro Spring 5\",\"author\":\"Luliana Cosmina\"},{\"id\":8,\"name\":\"Spring"
                                        + " 5.0 Cookbook\",\"author\":\"Sherwin John Calleja Tragura\"}]")));
    }

    @Test
    public void testGetBooks2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books", "uriVars");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "[{\"id\":1,\"name\":\"Beginning programming with C++ for dummies\",\"author\":\"Stephen R. Davis\"},{\"id\":2,"
                                        + "\"name\":\"Learning Python\",\"author\":\"Mark Lutz\"},{\"id\":3,\"name\":\"Domain Driven Design\",\"author\":\"Eric"
                                        + " Evans\"},{\"id\":4,\"name\":\"Agile Project Management for dummies\",\"author\":\"Mark C. Layton\"},{\"id\":5,"
                                        + "\"name\":\"Scrum for dummies\",\"author\":\"Mark C. Layton\"},{\"id\":6,\"name\":\"Java Design Patterns\",\"author\""
                                        + ":\"Vaskaran Sarcar\"},{\"id\":7,\"name\":\"Pro Spring 5\",\"author\":\"Luliana Cosmina\"},{\"id\":8,\"name\":\"Spring"
                                        + " 5.0 Cookbook\",\"author\":\"Sherwin John Calleja Tragura\"}]")));
    }
}

