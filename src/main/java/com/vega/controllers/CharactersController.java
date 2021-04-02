package com.vega.controllers;

import com.vega.services.CharactersService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.util.List;

@Controller("/characters")
@ExecuteOn(TaskExecutors.IO)
public class CharactersController {

    private static final Logger logger = LoggerFactory.getLogger(CharactersController.class);

    @Inject
    private CharactersService charactersService;

    @Get
    public HttpResponse<List<String>> getCharactersFromPlanet(@QueryValue String planetName) {
        List<String> characters;
        try {
            characters = charactersService.getCharactersFromPlanet(planetName);
        } catch (MalformedURLException e) {
            logger.error("Error: ", e.getMessage());
            return HttpResponse.serverError();
        }

        if(characters != null) {
            logger.info("Characters obtained from planet '" + planetName + "': " + characters.toString());
            return HttpResponse.ok(characters);
        }

        return HttpResponse.serverError();
    }
}
