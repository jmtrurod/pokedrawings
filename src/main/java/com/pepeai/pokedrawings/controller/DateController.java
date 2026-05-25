package com.pepeai.pokedrawings.controller;

import com.pepeai.pokedrawings.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller for handling date-related operations.
 * Provides endpoints for retrieving date information.
 */
@RestController
@RequestMapping("/api/date")
public class DateController {

    private static final Logger logger = LoggerFactory.getLogger(DateController.class);

    private final DateService dateService;

    /**
     * Constructs a new DateController with the given DateService.
     * @param dateService The service to handle date business logic.
     */
    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    /**
     * Retrieves the first day of the year for a given date.
     *
     * @param dateString The input date string in "YYYY-MM-DD" format.
     * @return A ResponseEntity containing the first day of the year as a string in "YYYY-MM-DD" format.
     */
    @GetMapping("/firstDayOfYear")
    public ResponseEntity<String> getFirstDayOfYear(@RequestParam("date") String dateString) {
        logger.info("Endpoint getFirstDayOfYear has been reached with parameters dateString=" + dateString);
        String firstDay = dateService.calculateFirstDayOfYear(dateString);
        return ResponseEntity.ok(firstDay);
    }
}
