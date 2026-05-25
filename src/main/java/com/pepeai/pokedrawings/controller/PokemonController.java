package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * REST controller for handling Pokémon-related requests.
 * Provides endpoints for retrieving Pokémon information.
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    private final PokemonService pokemonService;

    /**
     * Constructs a new PokemonController with the given PokemonService.
     *
     * @param pokemonService The service for handling Pokémon business logic.
     */
    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /**
     * Retrieves the name of a Pokémon based on its Pokedex number.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return A ResponseEntity containing the Pokémon's name as a String if found,
     *         or an appropriate error response if not.
     */
    @GetMapping("/{pokedexNumber}")
    public ResponseEntity<String> getPokemonNameByPokedexNumber(@PathVariable int pokedexNumber) {
        // RULE: First executable line must be this exact log format
        logger.info("Endpoint getPokemonNameByPokedexNumber has been reached with parameters pokedexNumber=" + pokedexNumber);

        String pokemonName = pokemonService.getPokemonNameByPokedexNumber(pokedexNumber);

        if (pokemonName != null) {
            return ResponseEntity.ok(pokemonName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
