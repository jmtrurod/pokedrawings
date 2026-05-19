package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PlanetController.class)
public class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllPlanets() throws Exception {
        mockMvc.perform(get("/planets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("Mercury"))
                .andExpect(jsonPath("$[1]").value("Venus"))
                .andExpect(jsonPath("$[2]").value("Earth"))
                .andExpect(jsonPath("$[3]").value("Mars"))
                .andExpect(jsonPath("$[4]").value("Jupiter"))
                .andExpect(jsonPath("$[5]").value("Saturn"))
                .andExpect(jsonPath("$[6]").value("Uranus"))
                .andExpect(jsonPath("$[7]").value("Neptune"))
                .andExpect(jsonPath("$[8]").value("Pluto"));
    }
}
