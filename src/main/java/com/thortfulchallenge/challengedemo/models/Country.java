package com.thortfulchallenge.challengedemo.models;

import com.thortfulchallenge.challengedemo.models.CountryName;
import com.thortfulchallenge.challengedemo.models.Idd;

import java.util.Currency;
import java.util.Dictionary;

public class Country {
    private CountryName name;
    private String[] tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private Boolean independent;
    private String status;
    private Boolean unMember;
    private Dictionary<String, Currency> currencies;
    private Idd idd;
    private String[] capital;
    private String[] altSpellings;
    private String region;
    private String subregion;
    private Dictionary<String, String> languages;
    private Dictionary<String, Translation> translations;
    private double[] latlng;
    private Boolean landlocked;
    private String[] borders;
    private Double area;
    private Demonyms demonyms;
    private String unicodeFlag;
    private Maps maps;
    private String fifa;
    private Car car;
    private String[] timezones;
    private String[] continents;
    private Flag flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;
    private int population;
    private Gini gini;

    // getters and setters
}
