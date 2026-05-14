package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighestNumberController {

    @GetMapping("/highest-number")
    public String getHighestNumber(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return String.valueOf(Math.max(num1, num2));
    }
}
