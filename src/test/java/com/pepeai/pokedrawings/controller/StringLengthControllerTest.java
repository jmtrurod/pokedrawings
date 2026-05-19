package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StringLengthController.class)
public class StringLengthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStringLength_shouldReturnCorrectLength() throws Exception {
        String testString = "hello";
        int expectedLength = testString.length();

        mockMvc.perform(get("/string-length")
                .param("inputString", testString))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedLength)));
    }
}
