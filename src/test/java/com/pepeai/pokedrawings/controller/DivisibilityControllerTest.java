package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DivisibilityController.class)
public class DivisibilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void isDivisibleByTwo_evenNumber_returnsTrue() throws Exception {
        mockMvc.perform(get("/divisibility/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void isDivisibleByTwo_oddNumber_returnsFalse() throws Exception {
        mockMvc.perform(get("/divisibility/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}
