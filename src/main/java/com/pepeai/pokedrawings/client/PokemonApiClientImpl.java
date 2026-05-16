package com.pepeai.pokedrawings.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PokemonApiClientImpl implements PokemonApiClient {

    private static final String POKEAPI_BASE_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public PokemonApiClientImpl() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String getPokemonName(int pokedexNumber) {
        String url = POKEAPI_BASE_URL + pokedexNumber;
        String response = restTemplate.getForObject(url, String.class);
        try {
            JsonNode root = objectMapper.readTree(response);
            String name = root.path("name").asText();
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Pokemon API response", e);
        }
    }
}
