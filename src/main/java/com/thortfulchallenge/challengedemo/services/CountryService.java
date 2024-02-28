package com.thortfulchallenge.challengedemo.services;

import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.models.Currency;

import java.util.List;
import java.util.Map;

public interface CountryService {
    List<Country> getCountries();
    Country getCountryByName(String name);

    String[] getCountryCapitalByName(String name);

    Map<String, Currency> getCountryCurrencyByName(String name);

    Map<String, String> getCountryLanguagesByName(String name);
    List<Country> getCountriesByTimezone(String timezone);

}