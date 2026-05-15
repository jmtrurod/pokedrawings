package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    private int currentNumber = 99;

    public int getNextNumber() {
        currentNumber++;
        return currentNumber;
    }
}
