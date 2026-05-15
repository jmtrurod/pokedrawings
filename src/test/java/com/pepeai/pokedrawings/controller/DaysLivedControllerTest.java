package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebMvcTest(DaysLivedController.class)
public class DaysLivedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculateDaysLived() throws Exception {
        String birthDateString = "1990-01-01";
        LocalDate birthDate = LocalDate.parse(birthDateString);
        LocalDate currentDate = LocalDate.now();
        long expectedDays = ChronoUnit.DAYS.between(birthDate, currentDate);

        mockMvc.perform(get("/days-lived")
                .param("birthDate", birthDateString))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedDays)));
    }

    @Test
    void testCalculateDaysLived_birthYearBefore1950_shouldReturnBadRequest() throws Exception {
        String birthDateString = "1949-12-31"; // A date before 1950
        mockMvc.perform(get("/days-lived")
                .param("birthDate", birthDateString))
                .andExpect(status().isBadRequest());
    }
}
