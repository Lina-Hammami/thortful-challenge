package com.thortfulchallenge.challengedemo.controllers;

import com.thortfulchallenge.challengedemo.excetions.ApiException;
import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.models.Currency;
import com.thortfulchallenge.challengedemo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class RestAPIController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        try {
            List<Country> countries = countryService.getCountries();
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{name}")
    public ResponseEntity<Object> getCountryByName(@PathVariable String name) {
        try {
            Object country = countryService.getCountryByName(name);
            return new ResponseEntity<>(country, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}/capital")
    public ResponseEntity<String[]> getCountryCapital(@PathVariable String name) {
        try {
            String[] capital = countryService.getCountryCapitalByName(name);
            return new ResponseEntity<>(capital, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}/currency")
    public ResponseEntity<Map<String, Currency>> getCountryCurrency(@PathVariable String name) {
        try {
            Map<String, Currency> currency = countryService.getCountryCurrencyByName(name);
            return new ResponseEntity<>(currency, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}/language")
    public ResponseEntity<Map<String, String>> getCountryLanguage(@PathVariable String name) {
        try {
            Map<String, String> language = countryService.getCountryLanguagesByName(name);
            return new ResponseEntity<>(language, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/timezone/{timezone}")
    public ResponseEntity<List<Country>> getCountriesByTimezone(@PathVariable String timezone) {
        try {
            List<Country> countries = countryService.getCountriesByTimezone(timezone);
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}