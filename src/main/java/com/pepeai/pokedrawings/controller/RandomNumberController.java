package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomNumberController {

    @GetMapping("/random-numbers")
    public String getRandomNumbers() {
        Random random = new Random();
        int num1 = random.nextInt(31) + 1; // Generates a number between 1 and 31
        int num2 = random.nextInt(31) + 1; // Generates a number between 1 and 31
        return num1 + "," + num2;
    }
}