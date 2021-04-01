package com.vega.clients;

import com.vega.clients.model.PlanetSearch;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://swapi.dev/api")
public interface PlanetsClient {

    @Get("/planets?search={name}")
    PlanetSearch getPlanetByName(String name);
}
