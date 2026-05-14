package com.pepeai.pokedrawings.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestNumberServiceTest {

    private HighestNumberService highestNumberService = new HighestNumberService();

    @Test
    void testFindHighestNumber() {
        assertEquals(10, highestNumberService.findHighest(5, 10));
        assertEquals(20, highestNumberService.findHighest(20, 15));
        assertEquals(7, highestNumberService.findHighest(7, 7));
        assertEquals(-1, highestNumberService.findHighest(-5, -1));
        assertEquals(0, highestNumberService.findHighest(0, -1));
    }
}
