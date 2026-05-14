package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.SumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        System.out.println("Here");
        return sumService.sum(a, b);
    }
}
