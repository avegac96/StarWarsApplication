package com.vega.clients;

import com.vega.clients.model.CharacterSearch;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import com.vega.clients.model.Character;

@Client("https://swapi.dev/api")
public interface CharactersClient {

    @Get("/people?search={name}")
    CharacterSearch getCharacterByName(String name);

    @Get("/people/{id}")
    Character getCharacterByID(String id);
}
