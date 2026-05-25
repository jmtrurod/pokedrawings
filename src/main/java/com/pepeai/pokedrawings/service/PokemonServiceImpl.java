package com.pepeai.pokedrawings.service;

import com.pepeai.pokedrawings.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of the {@link PokemonService} interface.
 * Handles the business logic for retrieving Pokémon information.
 */
@Service
public class PokemonServiceImpl implements PokemonService {

    private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class);

    private final PokemonRepository pokemonRepository;

    /**
     * Constructs a new PokemonServiceImpl with the given PokemonRepository.
     *
     * @param pokemonRepository The repository for accessing Pokémon data.
     */
    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    /**
     * Retrieves the name of a Pokémon based on its Pokedex number.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return The name of the Pokémon as a String, or null if not found.
     */
    @Override
    public String getPokemonNameByPokedexNumber(int pokedexNumber) {
        logger.info("Attempting to retrieve Pokémon name for Pokedex number: " + pokedexNumber);
        String pokemonName = pokemonRepository.findPokemonNameByPokedexNumber(pokedexNumber);
        if (pokemonName != null) {
            logger.info("Successfully retrieved Pokémon name: " + pokemonName + " for Pokedex number: " + pokedexNumber);
        } else {
            logger.warn("Pokémon name not found for Pokedex number: " + pokedexNumber);
        }
        return pokemonName;
    }
}
