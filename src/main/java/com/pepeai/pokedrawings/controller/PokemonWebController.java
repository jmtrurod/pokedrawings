package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

/**
 * Web controller responsible for handling requests related to displaying random Pokémon information
 * using Thymeleaf templates. It fetches Pokémon data from the {@link PokemonService} and
 * prepares it for rendering in the view.
 */
@Controller
public class PokemonWebController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonWebController.class);
    private final PokemonService pokemonService;
    private static final int MIN_POKEDEX_NUMBER = 1;
    private static final int MAX_POKEDEX_NUMBER = 500;

    /**
     * Constructs a new PokemonWebController with the given PokemonService.
     *
     * @param pokemonService The service responsible for fetching Pokémon data.
     */
    public PokemonWebController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /**
     * Handles GET requests to display a random Pokémon's information.
     * Generates a random Pokedex number, fetches the corresponding Pokémon's name, types,
     * description, and image URL using the {@link PokemonService}, and adds these details
     * to the Spring Model for rendering by a Thymeleaf template.
     *
     * @param model The Spring Model to which Pokémon data will be added for the view.
     * @return The logical view name "pokemon-display", which corresponds to the Thymeleaf template.
     */
    @GetMapping("/") // Changed mapping to root URL
    public String displayRandomPokemon(Model model) {
        // RULE: First executable line must be this exact log format
        logger.info("Endpoint displayRandomPokemon has been reached with no parameters");

        Random random = new Random();
        int pokedexNumber = random.nextInt(MAX_POKEDEX_NUMBER - MIN_POKEDEX_NUMBER + 1) + MIN_POKEDEX_NUMBER;

        String pokemonName = pokemonService.getPokemonNameByPokedexNumber(pokedexNumber);
        List<String> pokemonTypes = pokemonService.getPokemonTypesByPokedexNumber(pokedexNumber);
        String pokemonDescription = pokemonService.getPokemonDescriptionByPokedexNumber(pokedexNumber);
        String pokemonImageUrl = pokemonService.getPokemonImageByPokedexNumber(pokedexNumber);

        model.addAttribute("pokedexNumber", pokedexNumber);
        model.addAttribute("pokemonName", pokemonName);
        model.addAttribute("pokemonTypes", pokemonTypes);
        model.addAttribute("pokemonDescription", pokemonDescription);
        model.addAttribute("pokemonImageUrl", pokemonImageUrl);

        return "pokemon-display";
    }
}
