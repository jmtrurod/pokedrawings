package com.pepeai.pokedrawings.service;

/**
 * Service interface for handling Pokémon-related business logic.
 * Provides methods for retrieving Pokémon information.
 */
public interface PokemonService {

    /**
     * Retrieves the name of a Pokémon based on its Pokedex number.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return The name of the Pokémon as a String, or null if not found.
     */
    String getPokemonNameByPokedexNumber(int pokedexNumber);
}
