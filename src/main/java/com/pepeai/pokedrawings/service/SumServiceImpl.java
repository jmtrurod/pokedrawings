package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;

@Service
public class SumServiceImpl implements SumService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
