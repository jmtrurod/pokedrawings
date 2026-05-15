package com.pepeai.pokedrawings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class DaysLivedController {

    @GetMapping("/days-lived")
    public long calculateDaysLived(@RequestParam("birthDate") String birthDateString) {
        LocalDate birthDate = LocalDate.parse(birthDateString);

        if (birthDate.getYear() < 1950) {
            throw new IllegalArgumentException("Birth year cannot be before 1950.");
        }

        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(birthDate, currentDate);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
