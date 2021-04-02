package com.vega.clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Starship {

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("length")
    private String length;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;

    @JsonProperty("mglt")
    private String mglt;

    @JsonProperty("starship_class")
    private String starshipClass;

    @JsonProperty("pilots")
    private List<String> pilots;

    @JsonProperty("films")
    private List<String> films;
}
