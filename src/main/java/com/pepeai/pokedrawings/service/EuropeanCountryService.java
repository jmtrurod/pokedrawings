package com.pepeai.pokedrawings.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EuropeanCountryService {

    private static final Set<String> EUROPEAN_COUNTRIES = new HashSet<>(Arrays.asList(
        "Germany", "France", "Spain", "Italy", "Poland", "Ukraine", "Romania", "Netherlands", "Belgium",
        "Greece", "Portugal", "Sweden", "Czech Republic", "Hungary", "Austria", "Switzerland", "Bulgaria", "Denmark",
        "Finland", "Slovakia", "Norway", "Ireland", "Croatia", "Bosnia and Herzegovina", "Albania", "Lithuania",
        "Latvia", "Estonia", "Moldova", "Slovenia", "North Macedonia", "Serbia", "Montenegro", "Kosovo", "Cyprus",
        "Luxembourg", "Georgia", "Armenia", "Malta", "Iceland", "Andorra", "Monaco", "Liechtenstein", "San Marino",
        "Vatican City", "Belarus", "Russia",
        "Scotland", "England", "Wales"
    ));

    public boolean isEuropeanCountry(String countryName) {
        if (countryName == null || countryName.trim().isEmpty()) {
            return false;
        }
        return EUROPEAN_COUNTRIES.contains(countryName.trim());
    }
}
