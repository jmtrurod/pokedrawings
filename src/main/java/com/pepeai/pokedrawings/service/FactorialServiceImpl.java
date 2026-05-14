package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialServiceImpl implements FactorialService {

    @Override
    public int calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        if (number > 10) {
            throw new IllegalArgumentException("Number cannot be greater than 10 to calculate factorial.");
        }
        if (number == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}