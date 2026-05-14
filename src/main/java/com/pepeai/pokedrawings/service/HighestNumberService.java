package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;

@Service
public class HighestNumberService {

    public int findHighest(int number1, int number2) {
        return Math.max(number1, number2);
    }
}
