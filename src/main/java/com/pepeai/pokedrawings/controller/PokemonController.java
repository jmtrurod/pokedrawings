package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling Pokémon-related requests.
 * Provides endpoints to retrieve Pokémon information.
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    private final PokemonService pokemonService;

    /**
     * Constructs a new PokemonController with the given PokemonService.
     *
     * @param pokemonService The service responsible for Pokémon business logic.
     */
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /**
     * Retrieves the name of a Pokémon based on its Pokedex number.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return A ResponseEntity containing the name of the Pokémon if found, or an error status.
     */
    @GetMapping("/{pokedexNumber}")
    public ResponseEntity<String> getPokemonNameByPokedexNumber(@PathVariable int pokedexNumber) {
        logger.info("Endpoint getPokemonNameByPokedexNumber has been reached with parameters pokedexNumber=" + pokedexNumber);
        String pokemonName = pokemonService.getPokemonNameByPokedexNumber(pokedexNumber);
        return ResponseEntity.ok(pokemonName);
    }
}
