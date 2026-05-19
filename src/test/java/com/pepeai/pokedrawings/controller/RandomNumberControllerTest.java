package com.pepeai.pokedrawings.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(RandomNumberController.class) // Assuming the controller will be named RandomNumberController
public class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRandomNumbers_shouldReturnTwoNumbersBetween1And31() throws Exception {
        MvcResult result = mockMvc.perform(get("/random-numbers"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        String[] numbers = responseBody.split(","); // Assuming the response will be "num1,num2"

        assertTrue(numbers.length == 2, "Response should contain two numbers separated by a comma.");

        int num1 = Integer.parseInt(numbers[0].trim());
        int num2 = Integer.parseInt(numbers[1].trim());

        assertTrue(num1 >= 1 && num1 <= 31, "First number should be between 1 and 31.");
        assertTrue(num2 >= 1 && num2 <= 31, "Second number should be between 1 and 31.");
    }
}