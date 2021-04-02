package com.vega.clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Planet {

    @JsonProperty("name")
    private String name;

    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @JsonProperty("orbital_period")
    private String orbitalPeriod;

    @JsonProperty("diameter")
    private String diameter;

    @JsonProperty("climate")
    private String climate;

    @JsonProperty("gravity")
    private String gravity;

    @JsonProperty("terrain")
    private String terrain;

    @JsonProperty("surface_water")
    private String surfaceWater;

    @JsonProperty("population")
    private String population;

    @JsonProperty("residents")
    private List<String> residents;

    @JsonProperty("films")
    private List<String> films;
}
