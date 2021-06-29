package com.nagaty.neotask;
/* adapted from:
https://spring.io/guides/gs/testing-web/
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CheckoutEndpointTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void incorrectRequestMethod() throws Exception {
        this.mockMvc.perform(get("/checkout")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void emptyRequestBody() throws Exception {
        this.mockMvc.perform(post("/checkout")).andDo(print()).andExpect(status().is4xxClientError());
    }
}
