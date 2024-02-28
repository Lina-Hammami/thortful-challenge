package com.thortfulchallenge.challengedemo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Idd {
    private String root;
    private String[] suffixes;
}
