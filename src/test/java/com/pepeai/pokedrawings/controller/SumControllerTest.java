package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.pepeai.pokedrawings.service.SumService;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class SumControllerTest {

    private SumController sumController;
    private SumService sumService;

    @BeforeEach
    void setUp() {
        sumService = Mockito.mock(SumService.class);
        sumController = new SumController(sumService);
    }

    @Test
    void sum_shouldPrintHere() throws Exception {
        when(sumService.sum(1, 2)).thenReturn(3);
        String text = SystemLambda.tapSystemOut(() -> {
            sumController.sum(1, 2);
        });
        assertTrue(text.contains("Here"));
    }
}
