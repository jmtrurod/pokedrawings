package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StringComparisonController {

    @GetMapping("/longest-string")
    public String getLongestString(@RequestParam("string1") String string1,
                                   @RequestParam("string2") String string2) {
        if (string1.length() >= string2.length()) {
            return string1;
        } else {
            return string2;
        }
    }
}
