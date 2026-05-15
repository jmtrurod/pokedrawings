package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.NumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;

@WebMvcTest(NumberController.class)
@Import(NumberService.class)
public class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNextNumberReturnsIncreasingNumbers() throws Exception {
        // First call
        String response1 = mockMvc.perform(get("/api/number/next"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // Second call
        String response2 = mockMvc.perform(get("/api/number/next"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // Third call
        String response3 = mockMvc.perform(get("/api/number/next"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        int num1 = Integer.parseInt(response1);
        int num2 = Integer.parseInt(response2);
        int num3 = Integer.parseInt(response3);

        // Assert that numbers are increasing
        assert(num2 > num1);
        assert(num3 > num2);
    }
}
