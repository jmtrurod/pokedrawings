package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for the {@link PokemonWebController} class.
 * This class uses Mockito to mock the {@link PokemonService} and Spring's MockMvc to test the web layer.
 */
@ExtendWith(MockitoExtension.class)
class PokemonWebControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PokemonService pokemonService;

    @InjectMocks
    private PokemonWebController pokemonWebController;

    /**
     * Sets up the test environment before each test method.
     * Initializes MockMvc for standalone setup with the {@link PokemonWebController}.
     */
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pokemonWebController).build();
    }

    /**
     * Tests the {@code getPokemonDisplay} method to ensure it returns the "pokemon-display" view
     * with complete and correct Pokémon details when types are present.
     *
     * @throws Exception if an error occurs during the mock MVC perform operation.
     */
    @Test
    void getPokemonDisplay_shouldReturnPokemonDisplayViewWithPokemonDetails() throws Exception {
        // Given
        String expectedPokemonName = "Pikachu";
        String expectedPokemonDescription = "A mouse-like Pokémon that has the ability to generate powerful electricity.";
        String expectedPokemonImageUrl = "http://example.com/pikachu.png";
        when(pokemonService.getPokemonNameByPokedexNumber(anyInt())).thenReturn(expectedPokemonName);
        when(pokemonService.getPokemonTypesByPokedexNumber(anyInt())).thenReturn(Arrays.asList("Electric"));
        when(pokemonService.getPokemonDescriptionByPokedexNumber(anyInt())).thenReturn(expectedPokemonDescription);
        when(pokemonService.getPokemonImageByPokedexNumber(anyInt())).thenReturn(expectedPokemonImageUrl);

        // When & Then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("pokemon-display"))
                .andExpect(model().attributeExists("pokedexNumber", "pokemonName", "pokemonTypes", "pokemonDescription", "pokemonImageUrl"))
                .andExpect(model().attribute("pokemonName", expectedPokemonName))
                .andExpect(model().attribute("pokemonTypes", Arrays.asList("Electric")))
                .andExpect(model().attribute("pokemonDescription", expectedPokemonDescription))
                .andExpect(model().attribute("pokemonImageUrl", expectedPokemonImageUrl));
    }

    /**
     * Tests the {@code getPokemonDisplay} method to ensure it correctly handles scenarios
     * where a Pokémon has no associated types, returning the "pokemon-display" view
     * with other details intact and an empty list for types.
     *
     * @throws Exception if an error occurs during the mock MVC perform operation.
     */
    @Test
    void getPokemonDisplay_shouldHandleNoPokemonTypes() throws Exception {
        // Given
        String expectedPokemonName = "Missingno";
        String expectedPokemonDescription = "A glitch Pokémon.";
        String expectedPokemonImageUrl = "http://example.com/missingno.png";
        when(pokemonService.getPokemonNameByPokedexNumber(anyInt())).thenReturn(expectedPokemonName);
        when(pokemonService.getPokemonTypesByPokedexNumber(anyInt())).thenReturn(Collections.emptyList());
        when(pokemonService.getPokemonDescriptionByPokedexNumber(anyInt())).thenReturn(expectedPokemonDescription);
        when(pokemonService.getPokemonImageByPokedexNumber(anyInt())).thenReturn(expectedPokemonImageUrl);

        // When & Then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("pokemon-display"))
                .andExpect(model().attributeExists("pokedexNumber", "pokemonName", "pokemonTypes", "pokemonDescription", "pokemonImageUrl"))
                .andExpect(model().attribute("pokemonName", expectedPokemonName))
                .andExpect(model().attribute("pokemonTypes", Collections.emptyList()))
                .andExpect(model().attribute("pokemonDescription", expectedPokemonDescription))
                .andExpect(model().attribute("pokemonImageUrl", expectedPokemonImageUrl));
    }
}
