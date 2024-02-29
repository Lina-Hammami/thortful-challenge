package com.thortfulchallenge.challengedemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestAPIController.class)
class RestAPIControllerTest {

    @MockBean
    private CountryService countryService;
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCountries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$").isArray());
    }

    @Test
    public void testGetCountryByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/Tunisia"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher)content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher)jsonPath("$.name").value("Tunisia"));
    }

    @Test
    public void testGetCountryCapitalByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/Portugual/capital"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$").isString());
    }

    @Test
    public void testGetCountryCurrencyByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/Tunisia/currency"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher)content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher)jsonPath("$").isString());
    }

    @Test
    public void testGetCountryLanguageByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/Portugual/language"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher)content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher)jsonPath("$").isString());
    }

    @Test
    public void testGetCountriesByTimezone() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/timezone/UTC+02:00"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher)content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher)jsonPath("$").isArray());
    }
}
