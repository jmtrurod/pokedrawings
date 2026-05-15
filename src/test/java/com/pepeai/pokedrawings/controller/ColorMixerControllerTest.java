package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ColorMixerController.class)
public class ColorMixerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mixColors_redAndBlue_shouldReturnPurple() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "red")
                .param("color2", "blue"))
                .andExpect(status().isOk())
                .andExpect(content().string("purple"));
    }

    @Test
    void mixColors_blueAndRed_shouldReturnPurple() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "blue")
                .param("color2", "red"))
                .andExpect(status().isOk())
                .andExpect(content().string("purple"));
    }

    @Test
    void mixColors_redAndYellow_shouldReturnOrange() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "red")
                .param("color2", "yellow"))
                .andExpect(status().isOk())
                .andExpect(content().string("orange"));
    }

    @Test
    void mixColors_yellowAndRed_shouldReturnOrange() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "yellow")
                .param("color2", "red"))
                .andExpect(status().isOk())
                .andExpect(content().string("orange"));
    }

    @Test
    void mixColors_blueAndYellow_shouldReturnGreen() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "blue")
                .param("color2", "yellow"))
                .andExpect(status().isOk())
                .andExpect(content().string("green"));
    }

    @Test
    void mixColors_yellowAndBlue_shouldReturnGreen() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "yellow")
                .param("color2", "blue"))
                .andExpect(status().isOk())
                .andExpect(content().string("green"));
    }

    @Test
    void mixColors_unknownColors_shouldReturnUnknownMix() throws Exception {
        mockMvc.perform(get("/mixColors")
                .param("color1", "black")
                .param("color2", "white"))
                .andExpect(status().isOk())
                .andExpect(content().string("unknown mix"));
    }
}
