package com.pepeai.pokedrawings.model;

public class GameResult {
    private String playerChoice;
    private String computerChoice;
    private String result;

    public GameResult(String playerChoice, String computerChoice, String result) {
        this.playerChoice = playerChoice;
        this.computerChoice = computerChoice;
        this.result = result;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(String playerChoice) {
        this.playerChoice = playerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public void setComputerChoice(String computerChoice) {
        this.computerChoice = computerChoice;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
