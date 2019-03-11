package com.gentooboy.springbootci.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
@RunWith(SpringRunner.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        final ResultActions actions = this.mockMvc.perform(get("/greeting"))
                .andDo(print());

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("content").value("Hello, World!"));
    }

    @Test
    public void greetingShouldReturnMessageWithName() throws Exception {
        final ResultActions actions = this.mockMvc.perform(get("/greeting?name=Kim"))
                .andDo(print());

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("content").value("Hello, Kim!"));
    }

    @Test
    public void greetingShouldReturnMessageWithName() throws Exception {
        final ResultActions actions = this.mockMvc.perform(get("/test"))
                .andDo(print());

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(0))
                .andExpect(jsonPath("content").value("test"));
    }

}
