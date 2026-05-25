package com.pepeai.pokedrawings.service;

import com.pepeai.pokedrawings.model.PokemonApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class responsible for handling Pokémon-related business logic,
 * including fetching Pokémon data from external APIs.
 */
@Service
public class PokemonService {

    @Value("${pokeapi.base.url}")
    private String pokeApiBaseUrl;

    private final RestTemplate restTemplate;

    /**
     * Constructs a new PokemonService with the given RestTemplate.
     *
     * @param restTemplate The RestTemplate instance for making HTTP requests.
     */
    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves the name of a Pokémon by its Pokedex number from the PokeAPI.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return The name of the Pokémon.
     * @throws org.springframework.web.client.HttpClientErrorException if the Pokémon is not found (e.g., 404).
     * @throws org.springframework.web.client.RestClientException for other API call errors.
     */
    public String getPokemonNameByPokedexNumber(int pokedexNumber) {
        String apiUrl = pokeApiBaseUrl + "pokemon/" + pokedexNumber;
        PokemonApiResponse pokemonApiResponse = restTemplate.getForObject(apiUrl, PokemonApiResponse.class);
        if (pokemonApiResponse != null) {
            return pokemonApiResponse.getName();
        }
        return null; // Or throw a specific exception if name is expected to be always present
    }
}
