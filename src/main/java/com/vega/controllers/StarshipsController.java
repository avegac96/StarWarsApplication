package com.vega.controllers;

import com.vega.clients.model.Starship;
import com.vega.services.StarshipsService;
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

@Controller("/starships")
@ExecuteOn(TaskExecutors.IO)
public class StarshipsController {

    private static final Logger logger = LoggerFactory.getLogger(StarshipsController.class);

    @Inject
    private StarshipsService starshipsService;

    @Get
    public HttpResponse<List<Starship>> getStarshipsUsedByCharacter(@QueryValue String characterName) {
        List<Starship> starships;
        try {
            starships = starshipsService.getStarshipsUsedByCharacter(characterName);
        } catch (MalformedURLException e) {
            logger.error("Error: ", e.getMessage());
            return HttpResponse.serverError();
        }

        if(starships != null) {
            logger.info("Starships used by character '" + characterName + "': " + starships.toString());
            return HttpResponse.ok(starships);
        }

        return HttpResponse.serverError();
    }
}
