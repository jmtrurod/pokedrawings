package com.pepeai.pokedrawings.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EuropeanCountryServiceTest {

    private EuropeanCountryService europeanCountryService;

    @BeforeEach
    void setUp() {
        europeanCountryService = new EuropeanCountryService();
    }

    @Test
    void isEuropeanCountry_validEuropeanCountry_returnsTrue() {
        assertTrue(europeanCountryService.isEuropeanCountry("Germany"));
    }

    @Test
    void isEuropeanCountry_invalidNonEuropeanCountry_returnsFalse() {
        assertFalse(europeanCountryService.isEuropeanCountry("Japan"));
    }

    @Test
    void isEuropeanCountry_invalidNullInput_returnsFalse() {
        assertFalse(europeanCountryService.isEuropeanCountry(null));
    }

    @Test
    void isEuropeanCountry_invalidEmptyInput_returnsFalse() {
        assertFalse(europeanCountryService.isEuropeanCountry(""));
    }

    @Test
    void isEuropeanCountry_Russia_returnsTrue() {
        assertTrue(europeanCountryService.isEuropeanCountry("Russia"));
    }

    @Test
    void europeanCountries_splitUnitedKingdom_containsScotlandEnglandWalesAndNotUnitedKingdom() {
        assertFalse(europeanCountryService.isEuropeanCountry("United Kingdom"));
        assertTrue(europeanCountryService.isEuropeanCountry("Scotland"));
        assertTrue(europeanCountryService.isEuropeanCountry("England"));
        assertTrue(europeanCountryService.isEuropeanCountry("Wales"));
    }

    @Test
    void isEuropeanCountry_NorthMacedoniaChangedToMacedonia_returnsTrueForMacedoniaAndFalseForNorthMacedonia() {
        assertTrue(europeanCountryService.isEuropeanCountry("Macedonia"));
        assertFalse(europeanCountryService.isEuropeanCountry("North Macedonia"));
    }

    @Test
    void isEuropeanCountry_SpainRemoved_returnsFalse() {
        assertFalse(europeanCountryService.isEuropeanCountry("Spain"));
    }
}
