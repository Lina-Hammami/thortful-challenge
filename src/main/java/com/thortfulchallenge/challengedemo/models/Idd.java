package com.thortfulchallenge.challengedemo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class Idd {
    private String root;
    private String[] suffixes;
}
