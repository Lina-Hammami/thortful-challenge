package com.thortfulchallenge.challengedemo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class NativeName {
    private String official;
    private String common;

}