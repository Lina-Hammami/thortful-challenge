package com.thortfulchallenge.challengedemo.controllers;

import com.thortfulchallenge.challengedemo.excetions.ApiException;
import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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
}