package com.thortfulchallenge.challengedemo.controllers;

import com.thortfulchallenge.challengedemo.models.Country;
import com.thortfulchallenge.challengedemo.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
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

    @Test
    void testGetCountries() throws Exception {
        when(countryService.getCountries()).thenReturn(Arrays.asList(new Country(), new Country()));

        mockMvc.perform(get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType("application/json"))
                .andExpect((ResultMatcher) jsonPath("$").isArray())
                .andExpect((ResultMatcher) jsonPath("$.length()").value(2));
    }
}
