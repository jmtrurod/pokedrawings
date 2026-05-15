package com.pepeai.pokedrawings.controller;

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
    public String mixColors(@RequestParam String color1, @RequestParam String color2) {
        return colorMixerService.mixColors(color1, color2);
    }
}
