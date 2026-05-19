package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.notNullValue;

@WebMvcTest(RandomDateController.class)
public class RandomDateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRandomDate_shouldReturnOkAndRandomDate() throws Exception {
        mockMvc.perform(get("/random-date"))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }
}
