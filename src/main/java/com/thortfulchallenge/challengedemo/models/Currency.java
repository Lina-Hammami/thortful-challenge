package com.thortfulchallenge.challengedemo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Currency {
    private String name;
    private String symbol;

}