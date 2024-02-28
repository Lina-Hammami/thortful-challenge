package com.thortfulchallenge.challengedemo.servicesImpl;

import com.thortfulchallenge.challengedemo.excetions.ApiException;
import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Value("${third.party.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public CountryServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Country> getCountries() {
        try {
            Country[] countries = restTemplate.getForObject(apiUrl, Country[].class);
            return Arrays.asList(countries);
        } catch (Exception e) {
            throw new ApiException("Error fetching countries from the countries third-party API", e);
        }
    }
}