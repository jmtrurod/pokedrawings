package com.pepeai.pokedrawings.model;

/**
 * Represents the API response structure for a Pokémon, specifically for extracting the name.
 */
public class PokemonApiResponse {
    private String name;

    /**
     * Gets the name of the Pokémon.
     *
     * @return The name of the Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Pokémon.
     *
     * @param name The name of the Pokémon.
     */
    public void setName(String name) {
        this.name = name;
    }
}
