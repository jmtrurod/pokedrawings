package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{pokedexNumber}/name")
    public String getPokemonName(@PathVariable int pokedexNumber) {
        return pokemonService.getPokemonName(pokedexNumber);
    }
}
