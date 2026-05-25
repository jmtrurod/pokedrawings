package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

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
     * Tests that the GET /api/pokemon/{pokedexNumber} endpoint returns the correct Pokémon name
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
        mockMvc.perform(get("/api/pokemon/{pokedexNumber}", pokedexNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedPokemonName));
    }

    /**
     * Tests that the GET /api/pokemon/{pokedexNumber}/types endpoint returns a list of Pokémon types
     * when a valid Pokedex number is provided.
     *
     * @throws Exception if an error occurs during the mock MVC request.
     */
    @Test
    void getPokemonTypesByPokedexNumber_shouldReturnListOfTypes() throws Exception {
        // Arrange
        int pokedexNumber = 1;
        List<String> expectedPokemonTypes = Arrays.asList("grass", "poison");
        String expectedJson = "[\"grass\",\"poison\"]";
        when(pokemonService.getPokemonTypesByPokedexNumber(pokedexNumber)).thenReturn(expectedPokemonTypes);

        // Act & Assert
        mockMvc.perform(get("/api/pokemon/{pokedexNumber}/types", pokedexNumber))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    /**
     * Tests that the GET /api/pokemon/{pokedexNumber}/description endpoint returns the correct Pokémon description
     * when a valid Pokedex number is provided.
     *
     * @throws Exception if an error occurs during the mock MVC request.
     */
    @Test
    void getPokemonDescriptionByPokedexNumber_shouldReturnPokemonDescription() throws Exception {
        // Arrange
        int pokedexNumber = 1;
        String expectedPokemonDescription = "Bulbasaur can be seen napping in the sun and is a grass/poison type.";
        when(pokemonService.getPokemonDescriptionByPokedexNumber(pokedexNumber)).thenReturn(expectedPokemonDescription);

        // Act & Assert
        mockMvc.perform(get("/api/pokemon/{pokedexNumber}/description", pokedexNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedPokemonDescription));
    }
}
