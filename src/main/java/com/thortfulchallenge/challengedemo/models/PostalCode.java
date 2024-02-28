package com.thortfulchallenge.challengedemo.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PostalCode {
    private String format;
    private String regex;
}
