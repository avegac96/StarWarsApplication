package com.vega.clients;

import com.vega.clients.model.Starship;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://swapi.dev/api")
public interface StarshipsClient {

    @Get("/starships/{id}")
    Starship getStarshipByID(String id);
}
