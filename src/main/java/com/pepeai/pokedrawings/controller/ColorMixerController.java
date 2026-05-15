package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorMixerController {

    @GetMapping("/mixColors")
    public String mixColors(@RequestParam String color1, @RequestParam String color2) {
        String lowerColor1 = color1.toLowerCase();
        String lowerColor2 = color2.toLowerCase();

        if ((lowerColor1.equals("red") && lowerColor2.equals("blue")) || (lowerColor1.equals("blue") && lowerColor2.equals("red"))) {
            return "purple";
        } else if ((lowerColor1.equals("red") && lowerColor2.equals("yellow")) || (lowerColor1.equals("yellow") && lowerColor2.equals("red"))) {
            return "orange";
        } else if ((lowerColor1.equals("blue") && lowerColor2.equals("yellow")) || (lowerColor1.equals("yellow") && lowerColor2.equals("blue"))) {
            return "green";
        }
        return "unknown mix";
    }
}
