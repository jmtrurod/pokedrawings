package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringLengthController {

    @GetMapping("/string-length")
    public int getStringLength(@RequestParam String inputString) {
        return inputString.length();
    }
}
