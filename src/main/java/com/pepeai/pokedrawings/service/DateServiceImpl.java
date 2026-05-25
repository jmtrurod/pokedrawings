package com.pepeai.pokedrawings.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Implementation of the {@link DateService} interface.
 * Provides concrete business logic for date operations, such as calculating the first day of the year.
 */
@Service
public class DateServiceImpl implements DateService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    /**
     * Calculates the first day of the year for a given date string.
     * The input date string is expected to be in "YYYY-MM-DD" format.
     * The method parses the input date, gets its year, and then constructs a new date representing January 1st of that year.
     *
     * @param dateString The input date string (e.g., "2023-10-26").
     * @return A string representing the first day of the year (e.g., "2023-01-01").
     */
    @Override
    public String calculateFirstDayOfYear(String dateString) {
        LocalDate inputDate = LocalDate.parse(dateString, DATE_FORMATTER);
        LocalDate firstDayOfYear = inputDate.withDayOfYear(1);
        return firstDayOfYear.format(DATE_FORMATTER);
    }
}
