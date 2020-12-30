package be.dog.d.steven.security.api;

import be.dog.d.steven.security.model.Student;
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

@ContextConfiguration(classes = {StudentAdminController.class})
@ExtendWith(SpringExtension.class)
public class StudentAdminControllerTest {
    @Autowired
    private StudentAdminController studentAdminController;

    @Test
    public void testRegisterStudent() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .delete("https://example.org/example", "foo", "foo", "foo")
                .contentType(MediaType.APPLICATION_JSON);
        Student value = new Student(123, "Student Name");
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(value));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.studentAdminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

