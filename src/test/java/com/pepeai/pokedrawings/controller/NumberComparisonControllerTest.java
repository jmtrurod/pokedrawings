package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NumberComparisonController.class)
public class NumberComparisonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBiggerThan4WhenInputIs5() throws Exception {
        mockMvc.perform(get("/compare/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Bigger than 4"));
    }

    @Test
    void shouldReturnSmallerThan4WhenInputIs3() throws Exception {
        mockMvc.perform(get("/compare/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Smaller than 4"));
    }
}
