package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/divisibility")
public class DivisibilityController {

    @GetMapping("/{number}")
    public boolean isDivisibleByTwo(@PathVariable int number) {
        return number % 2 == 0;
    }
}
