package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.model.RgbColor;
import com.pepeai.pokedrawings.service.ColorMixerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorMixerController {

    private final ColorMixerService colorMixerService;

    @Autowired
    public ColorMixerController(ColorMixerService colorMixerService) {
        this.colorMixerService = colorMixerService;
    }

    @GetMapping("/mixColors")
    public RgbColor mixColors(
            @RequestParam int r1, @RequestParam int g1, @RequestParam int b1,
            @RequestParam int r2, @RequestParam int g2, @RequestParam int b2) {

        RgbColor color1 = new RgbColor(r1, g1, b1);
        RgbColor color2 = new RgbColor(r2, g2, b2);

        return colorMixerService.mixColors(color1, color2);
    }
}
