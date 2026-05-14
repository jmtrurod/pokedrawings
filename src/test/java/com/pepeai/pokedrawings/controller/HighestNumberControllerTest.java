package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HighestNumberController.class)
public class HighestNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHighestNumberWhenFirstNumberIsHigher() throws Exception {
        mockMvc.perform(get("/highest-number")
                        .param("num1", "10")
                        .param("num2", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void shouldReturnHighestNumberWhenSecondNumberIsHigher() throws Exception {
        mockMvc.perform(get("/highest-number")
                        .param("num1", "5")
                        .param("num2", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void shouldReturnEitherNumberWhenNumbersAreEqual() throws Exception {
        mockMvc.perform(get("/highest-number")
                        .param("num1", "7")
                        .param("num2", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }
}
