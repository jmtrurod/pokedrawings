package com.pepeai.pokedrawings.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorMixerServiceTest {

    private ColorMixerService colorMixerService;

    @BeforeEach
    void setUp() {
        colorMixerService = new ColorMixerService();
    }

    @Test
    void testMixRedAndBlueReturnsPurple() {
        assertEquals("purple", colorMixerService.mixColors("red", "blue"));
    }

    @Test
    void testMixRedAndYellowReturnsOrange() {
        assertEquals("orange", colorMixerService.mixColors("red", "yellow"));
    }

    @Test
    void testMixBlueAndYellowReturnsGreen() {
        assertEquals("green", colorMixerService.mixColors("blue", "yellow"));
    }

    @Test
    void testMixUnknownColorsReturnsUnknownMix() {
        assertEquals("unknown mix", colorMixerService.mixColors("black", "white"));
    }
}
