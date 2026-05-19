package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberComparisonController {

    @GetMapping("/compare/{number}")
    public String compareNumber(@PathVariable int number) {
        if (number > 4) {
            return "Bigger than 4";
        } else {
            return "Smaller than 4";
        }
    }
}
