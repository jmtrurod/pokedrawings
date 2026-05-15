package com.pepeai.pokedrawings.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberServiceTest {

    @InjectMocks
    private NumberService numberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldStartFromOneHundred() {
        assertEquals(100, numberService.getNextNumber(), "The starting number should be 100");
    }
}
