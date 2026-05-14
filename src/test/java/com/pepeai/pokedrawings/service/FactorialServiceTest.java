package com.pepeai.pokedrawings.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialServiceTest {

    private FactorialService factorialService;

    @BeforeEach
    void setUp() {
        factorialService = new FactorialServiceImpl();
    }

    @Test
    void calculateFactorial_shouldReturnCorrectFactorialForValidNumbers() {
        assertEquals(1, factorialService.calculateFactorial(0));
        assertEquals(1, factorialService.calculateFactorial(1));
        assertEquals(2, factorialService.calculateFactorial(2));
        assertEquals(6, factorialService.calculateFactorial(3));
        assertEquals(120, factorialService.calculateFactorial(5));
        assertEquals(3628800, factorialService.calculateFactorial(10));
    }

    @Test
    void calculateFactorial_shouldThrowExceptionForNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factorialService.calculateFactorial(-1);
        });
        assertEquals("Number must be non-negative.", exception.getMessage());
    }

    @Test
    void calculateFactorial_shouldThrowExceptionForNumbersGreaterThanTen() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factorialService.calculateFactorial(11);
        });
        assertEquals("Number cannot be greater than 10 to calculate factorial.", exception.getMessage());
    }
}