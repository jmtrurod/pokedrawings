package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.model.GameResult;
import com.pepeai.pokedrawings.model.PlayerChoice;
import com.pepeai.pokedrawings.model.PlayerChoiceRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {

    private final Random random = new Random();

    @PostMapping("/play")
    public GameResult playGame(@RequestBody PlayerChoiceRequest request) {
        PlayerChoice playerChoice = PlayerChoice.valueOf(request.getPlayerChoice().toUpperCase());
        PlayerChoice computerChoice = PlayerChoice.values()[random.nextInt(PlayerChoice.values().length)];
        String result = determineWinner(playerChoice, computerChoice);
        return new GameResult(playerChoice.name().toLowerCase(), computerChoice.name().toLowerCase(), result);
    }

    private String determineWinner(PlayerChoice playerChoice, PlayerChoice computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "draw";
        }
        switch (playerChoice) {
            case ROCK:
                return (computerChoice.equals(PlayerChoice.SCISSORS)) ? "win" : "lose";
            case PAPER:
                return (computerChoice.equals(PlayerChoice.ROCK)) ? "win" : "lose";
            case SCISSORS:
                return (computerChoice.equals(PlayerChoice.PAPER)) ? "win" : "lose";
            default:
                return "invalid choice"; // Should not happen with validation
        }
    }
}
