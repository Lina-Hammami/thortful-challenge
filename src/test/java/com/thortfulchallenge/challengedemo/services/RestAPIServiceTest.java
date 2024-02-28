package com.thortfulchallenge.challengedemo.services;

import com.thortfulchallenge.challengedemo.excetions.ApiException;
import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.services.CountryService;
import com.thortfulchallenge.challengedemo.servicesImpl.CountryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CountryServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Test
    void testGetCountries() {
        Country[] countries = {new Country(), new Country()};
        when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Country[].class)))
                .thenReturn(countries);

        CountryService countryService = new CountryServiceImpl(restTemplate);
//        List<Country> result = countryService.getCountries();

//        assertEquals(2, result.size());
    }

    @Test
    void testGetCountriesWithError() {
        when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Country[].class)))
                .thenThrow(new RuntimeException("Some error occurred"));

        CountryService countryService = new CountryServiceImpl(restTemplate);

        try {
            countryService.getCountries();
        } catch (ApiException e) {
            assertEquals("Error fetching countries from the third-party API", e.getMessage());
        }
    }
}