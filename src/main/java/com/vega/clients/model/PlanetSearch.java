package com.vega.clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlanetSearch extends Search{

    @JsonProperty("results")
    private List<Planet> planets;

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
