package com.pepeai.pokedrawings.service;

import com.pepeai.pokedrawings.model.PokemonApiResponse;
import com.pepeai.pokedrawings.model.PokemonApiResponse.TypeWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Retrieves a list of types for a Pokémon by its Pokedex number from the PokeAPI.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return A list of strings representing the Pokémon's types.
     * @throws org.springframework.web.client.HttpClientErrorException if the Pokémon is not found (e.g., 404).
     * @throws org.springframework.web.client.RestClientException for other API call errors.
     */
    public List<String> getPokemonTypesByPokedexNumber(int pokedexNumber) {
        String apiUrl = pokeApiBaseUrl + "pokemon/" + pokedexNumber;
        PokemonApiResponse pokemonApiResponse = restTemplate.getForObject(apiUrl, PokemonApiResponse.class);
        if (pokemonApiResponse != null && pokemonApiResponse.getTypes() != null) {
            return pokemonApiResponse.getTypes().stream()
                    .map(typeWrapper -> typeWrapper.getType().getName())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * Retrieves the description of a Pokémon by its Pokedex number from the PokeAPI.
     *
     * @param pokedexNumber The unique identifier (Pokedex number) of the Pokémon.
     * @return The description of the Pokémon in English, or null if not found.
     * @throws org.springframework.web.client.HttpClientErrorException if the Pokémon is not found (e.g., 404).
     * @throws org.springframework.web.client.RestClientException for other API call errors.
     */
    public String getPokemonDescriptionByPokedexNumber(int pokedexNumber) {
        String apiUrl = pokeApiBaseUrl + "pokemon-species/" + pokedexNumber; // Description is in pokemon-species endpoint
        PokemonApiResponse pokemonApiResponse = restTemplate.getForObject(apiUrl, PokemonApiResponse.class);
        if (pokemonApiResponse != null && pokemonApiResponse.getFlavorTextEntries() != null) {
            return pokemonApiResponse.getFlavorTextEntries().stream()
                    .filter(entry -> "en".equals(entry.getLanguage().getName()))
                    .findFirst()
                    .map(entry -> entry.getFlavorText().replace("\n", " ").replace("\f", " "))
                    .orElse(null);
        }
        return null;
    }
}
