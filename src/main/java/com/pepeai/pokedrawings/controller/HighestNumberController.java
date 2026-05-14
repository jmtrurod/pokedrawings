package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.HighestNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighestNumberController {

    @Autowired
    private HighestNumberService highestNumberService;

    @GetMapping("/highest-number")
    public int getHighestNumber(@RequestParam int number1, @RequestParam int number2) {
        return highestNumberService.findHighest(number1, number2);
    }
}
