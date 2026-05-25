package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(PokemonController.class)
class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    void getPokemonNameByPokedexNumber_shouldReturnPokemonName() throws Exception {
        int pokedexNumber = 1;
        String expectedPokemonName = "bulbasaur"; // Lowercase as per API response

        when(pokemonService.getPokemonNameByPokedexNumber(pokedexNumber)).thenReturn(expectedPokemonName);

        mockMvc.perform(get("/pokemon/{pokedexNumber}", pokedexNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedPokemonName));
    }

    @Test
    void getPokemonNameByPokedexNumber_shouldReturnNotFoundForUnknownPokemon() throws Exception {
        int pokedexNumber = 999; // An unknown Pokedex number

        when(pokemonService.getPokemonNameByPokedexNumber(pokedexNumber)).thenReturn(null);

        mockMvc.perform(get("/pokemon/{pokedexNumber}", pokedexNumber))
                .andExpect(status().isNotFound());
    }
}
