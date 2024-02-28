package com.thortfulchallenge.challengedemo.servicesImpl;

import com.thortfulchallenge.challengedemo.excetions.ApiException;
import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.models.Currency;
import com.thortfulchallenge.challengedemo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            String apiUrlAll = apiUrl + "/all";
            Country[] countries = restTemplate.getForObject(apiUrlAll, Country[].class);
            return Arrays.asList(countries);
        } catch (Exception e) {
            throw new ApiException("Error fetching countries from the countries third-party API", e);
        }
    }

    @Override
    public Country getCountryByName(String name) {
        try {
            String apiUrlWithName = apiUrl + "/name/" + name;
            Country[] countries = restTemplate.getForObject(apiUrlWithName, Country[].class);

            if (countries != null && countries.length > 0) {
                return countries[0];
            } else {
                throw new ApiException("Country not found with name: " + name, null);
            }
        } catch (Exception e) {
            throw new ApiException("Error fetching country details by name from the countries third-party API", e);
        }
    }

    @Override
    public String[] getCountryCapitalByName(String name) {
        try {
            Country country = getCountryByName(name);
            return country.getCapital();
        } catch (Exception e) {
            throw new ApiException("Error fetching country capital by name from the countries third-party API", e);
        }
    }

    @Override
    public Map<String, Currency> getCountryCurrencyByName(String name) {
        try {
            Country country = getCountryByName(name);
            return country.getCurrencies();
        } catch (Exception e) {
            throw new ApiException("Error fetching country currency by name from the countries third-party API", e);
        }
    }

    @Override
    public Map<String, String> getCountryLanguagesByName(String name) {
        try {
            Country country = getCountryByName(name);
            return country.getLanguages();
        } catch (Exception e) {
            throw new ApiException("Error fetching country language by name from the countries third-party API", e);
        }
    }

    @Override
    public List<Country> getCountriesByTimezone(String timezone) {
        try {
            List<Country> allCountries = getCountries();
            return allCountries.stream()
                    .filter(country -> Arrays.stream(country.getTimezones()).anyMatch(tz -> tz.equals(timezone)))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ApiException("Error fetching countries by timezone from the countries third-party API", e);
        }
    }
}