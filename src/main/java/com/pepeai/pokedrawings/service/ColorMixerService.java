package com.pepeai.pokedrawings.service;

import com.pepeai.pokedrawings.model.RgbColor;
import org.springframework.stereotype.Service;

@Service
public class ColorMixerService {

    public RgbColor mixColors(RgbColor color1, RgbColor color2) {
        int mixedR = (color1.getRed() + color2.getRed()) / 2;
        int mixedG = (color1.getGreen() + color2.getGreen()) / 2;
        int mixedB = (color1.getBlue() + color2.getBlue()) / 2;
        return new RgbColor(mixedR, mixedG, mixedB);
    }
}
