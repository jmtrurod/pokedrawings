package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ColorMixerService {

    private static final Map<String, int[]> COLOR_TO_RGB = new HashMap<>();
    private static final Map<String, String> RGB_TO_COLOR = new HashMap<>();

    static {
        COLOR_TO_RGB.put("red", new int[]{255, 0, 0});
        COLOR_TO_RGB.put("blue", new int[]{0, 0, 255});
        COLOR_TO_RGB.put("yellow", new int[]{255, 255, 0});

        RGB_TO_COLOR.put("127,0,127", "purple");
        RGB_TO_COLOR.put("255,127,0", "orange");
        RGB_TO_COLOR.put("127,127,127", "green"); // Corrected mapping for green
    }

    public String mixColors(String color1, String color2) {
        int[] rgb1 = COLOR_TO_RGB.get(color1.toLowerCase());
        int[] rgb2 = COLOR_TO_RGB.get(color2.toLowerCase());

        if (rgb1 == null || rgb2 == null) {
            return "unknown mix";
        }

        int mixedR = (rgb1[0] + rgb2[0]) / 2;
        int mixedG = (rgb1[1] + rgb2[1]) / 2;
        int mixedB = (rgb1[2] + rgb2[2]) / 2;

        String mixedRgbKey = String.format("%d,%d,%d", mixedR, mixedG, mixedB);

        return RGB_TO_COLOR.getOrDefault(mixedRgbKey, "unknown mix");
    }
}
