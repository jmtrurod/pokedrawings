package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.DateService;
import com.pepeai.pokedrawings.service.DateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DateController.class)
@Import(DateServiceImpl.class)
public class DateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFirstDayOfYear_shouldReturnFirstDayOfGivenYear() throws Exception {
        String inputDate = "2023-10-26";
        String expectedFirstDayOfYear = "2023-01-01";

        mockMvc.perform(get("/api/date/firstDayOfYear")
                .param("date", inputDate))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedFirstDayOfYear));
    }
}
