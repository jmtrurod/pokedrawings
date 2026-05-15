package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.model.GameResult;
import com.pepeai.pokedrawings.model.PlayerChoice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {

    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private final Random random = new Random();

    @PostMapping("/play")
    public GameResult playGame(@RequestBody PlayerChoice playerChoice) {
        String computerChoice = CHOICES[random.nextInt(CHOICES.length)];
        String result = determineWinner(playerChoice.getPlayerChoice(), computerChoice);
        return new GameResult(playerChoice.getPlayerChoice(), computerChoice, result);
    }

    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "draw";
        }
        switch (playerChoice) {
            case "rock":
                return (computerChoice.equals("scissors")) ? "win" : "lose";
            case "paper":
                return (computerChoice.equals("rock")) ? "win" : "lose";
            case "scissors":
                return (computerChoice.equals("paper")) ? "win" : "lose";
            default:
                return "invalid choice"; // Should not happen with validation
        }
    }
}
