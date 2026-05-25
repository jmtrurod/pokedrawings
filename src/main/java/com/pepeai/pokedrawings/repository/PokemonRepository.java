package com.pepeai.pokedrawings.repository;

/**
 * Repository interface for data access operations related to Pokémon.
 * Provides methods for retrieving Pokémon data from external sources.
 */
public interface PokemonRepository {

    /**
     * Finds the name of a Pokémon based on its Pokedex number.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return The name of the Pokémon as a String, or null if not found.
     */
    String findPokemonNameByPokedexNumber(int pokedexNumber);
}
