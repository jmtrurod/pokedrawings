package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;
import com.pepeai.pokedrawings.client.PokemonApiClient;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonApiClient pokemonApiClient;

    public PokemonServiceImpl(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }

    @Override
    public String getPokemonName(int pokedexNumber) {
        return pokemonApiClient.getPokemonName(pokedexNumber);
    }
}
