package com.pepeai.pokedrawings.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RgbColorTest {

    @Test
    void testConstructorAndGetters() {
        RgbColor color = new RgbColor(255, 0, 128);
        assertEquals(255, color.getRed());
        assertEquals(0, color.getGreen());
        assertEquals(128, color.getBlue());
    }

    @Test
    void testEqualsAndHashCode() {
        RgbColor color1 = new RgbColor(255, 0, 128);
        RgbColor color2 = new RgbColor(255, 0, 128);
        RgbColor color3 = new RgbColor(0, 0, 0);

        assertEquals(color1, color2);
        assertNotEquals(color1, color3);
        assertEquals(color1.hashCode(), color2.hashCode());
        assertNotEquals(color1.hashCode(), color3.hashCode());
    }

    @Test
    void testToString() {
        RgbColor color = new RgbColor(255, 0, 128);
        assertEquals("RgbColor{red=255, green=0, blue=128}", color.toString());
    }
}
