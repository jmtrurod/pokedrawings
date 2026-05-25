package com.pepeai.pokedrawings.service;

/**
 * Service interface for handling date-related business logic.
 * Defines operations for calculating and manipulating dates.
 */
public interface DateService {

    /**
     * Calculates the first day of the year for a given date string.
     *
     * @param dateString The input date string in "YYYY-MM-DD" format.
     * @return The first day of the year as a string in "YYYY-MM-DD" format.
     */
    String calculateFirstDayOfYear(String dateString);
}
