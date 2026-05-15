package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.model.RgbColor;
import com.pepeai.pokedrawings.service.ColorMixerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ColorMixerController.class)
public class ColorMixerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColorMixerService colorMixerService;

    @Test
    void testMixColors_validInput_returnsRgbColor() throws Exception {
        RgbColor expectedColor = new RgbColor(127, 0, 127);
        when(colorMixerService.mixColors(any(RgbColor.class), any(RgbColor.class)))
                .thenReturn(expectedColor);

        mockMvc.perform(get("/mixColors")
                .param("r1", "255")
                .param("g1", "0")
                .param("b1", "0")
                .param("r2", "0")
                .param("g2", "0")
                .param("b2", "255"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.red").value(127))
                .andExpect(jsonPath("$.green").value(0))
                .andExpect(jsonPath("$.blue").value(127));
    }
}
