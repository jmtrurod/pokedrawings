package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class DaysLivedController {

    @GetMapping("/days-lived")
    public long calculateDaysLived(@RequestParam("birthDate") String birthDateString) {
        LocalDate birthDate = LocalDate.parse(birthDateString);
        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(birthDate, currentDate);
    }
}
