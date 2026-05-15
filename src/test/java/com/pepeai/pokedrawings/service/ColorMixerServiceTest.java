package com.pepeai.pokedrawings.service;

import com.pepeai.pokedrawings.model.RgbColor;
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
    void testMixRgbColorsAveragesComponents() {
        RgbColor color1 = new RgbColor(255, 0, 0); // Red
        RgbColor color2 = new RgbColor(0, 0, 255); // Blue
        RgbColor mixedColor = colorMixerService.mixColors(color1, color2);

        assertEquals(127, mixedColor.getRed());
        assertEquals(0, mixedColor.getGreen());
        assertEquals(127, mixedColor.getBlue());
    }

    @Test
    void testMixRgbColorsWithDifferentComponents() {
        RgbColor color1 = new RgbColor(100, 50, 200);
        RgbColor color2 = new RgbColor(200, 150, 100);
        RgbColor mixedColor = colorMixerService.mixColors(color1, color2);

        assertEquals(150, mixedColor.getRed());
        assertEquals(100, mixedColor.getGreen());
        assertEquals(150, mixedColor.getBlue());
    }

    @Test
    void testMixRgbColorsWithZeroComponents() {
        RgbColor color1 = new RgbColor(0, 0, 0); // Black
        RgbColor color2 = new RgbColor(0, 0, 0); // Black
        RgbColor mixedColor = colorMixerService.mixColors(color1, color2);

        assertEquals(0, mixedColor.getRed());
        assertEquals(0, mixedColor.getGreen());
        assertEquals(0, mixedColor.getBlue());
    }

    @Test
    void testMixRgbColorsWithMaxComponents() {
        RgbColor color1 = new RgbColor(255, 255, 255); // White
        RgbColor color2 = new RgbColor(255, 255, 255); // White
        RgbColor mixedColor = colorMixerService.mixColors(color1, color2);

        assertEquals(255, mixedColor.getRed());
        assertEquals(255, mixedColor.getGreen());
        assertEquals(255, mixedColor.getBlue());
    }
}
