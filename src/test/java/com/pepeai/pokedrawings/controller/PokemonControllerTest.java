package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for the {@link PokemonController} class.
 * This class uses Spring's {@link WebMvcTest} to focus on testing the web layer,
 * and mocks the {@link PokemonService} to isolate the controller's behavior.
 */
@WebMvcTest(PokemonController.class)
class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    /**
     * Tests that the GET /pokemon/{pokedexNumber} endpoint returns the correct Pokémon name
     * when a valid Pokedex number is provided.
     *
     * @throws Exception if an error occurs during the mock MVC request.
     */
    @Test
    void getPokemonNameByPokedexNumber_shouldReturnPokemonName() throws Exception {
        // Arrange
        int pokedexNumber = 1;
        String expectedPokemonName = "bulbasaur";
        when(pokemonService.getPokemonNameByPokedexNumber(pokedexNumber)).thenReturn(expectedPokemonName);

        // Act & Assert
        mockMvc.perform(get("/pokemon/{pokedexNumber}", pokedexNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedPokemonName));
    }
}
