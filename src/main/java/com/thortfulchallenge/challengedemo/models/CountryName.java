package com.thortfulchallenge.challengedemo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class CountryName {
    private  String common;
    private  String official;
    private Map<String, NativeName> nativeName;

}
