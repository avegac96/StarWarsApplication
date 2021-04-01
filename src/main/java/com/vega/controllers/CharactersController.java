package com.vega.controllers;

import com.vega.services.CharactersService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.util.List;

@Controller("/characters")
@ExecuteOn(TaskExecutors.IO)
public class CharactersController {

    @Inject
    private CharactersService charactersService;

    @Get
    public List<String> getCharactersFromPlanet(@QueryValue String planetName) {
        try {
            return charactersService.getCharactersFromPlanet(planetName);
        } catch (MalformedURLException e) {
            // Pintamos log y devolvemos un HTTP Response de error
            e.printStackTrace();
        }

        return null;
    }
}
