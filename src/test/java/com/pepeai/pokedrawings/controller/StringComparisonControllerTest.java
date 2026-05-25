package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StringComparisonController.class)
public class StringComparisonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnLongestString() throws Exception {
        mockMvc.perform(get("/api/longest-string")
                .param("string1", "hello")
                .param("string2", "worlddd"))
                .andExpect(status().isOk())
                .andExpect(content().string("worlddd"));
    }

    @Test
    void shouldReturnFirstStringIfLengthsAreEqual() throws Exception {
        mockMvc.perform(get("/api/longest-string")
                .param("string1", "hello")
                .param("string2", "world"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    void shouldReturnEmptyStringIfBothAreEmpty() throws Exception {
        mockMvc.perform(get("/api/longest-string")
                .param("string1", "")
                .param("string2", ""))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void shouldHandleOneEmptyString() throws Exception {
        mockMvc.perform(get("/api/longest-string")
                .param("string1", "test")
                .param("string2", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("test"));
    }
}
