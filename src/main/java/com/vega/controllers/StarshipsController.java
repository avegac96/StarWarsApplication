package com.vega.controllers;

import com.vega.clients.model.Starship;
import com.vega.services.StarshipsService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.util.List;

@Controller("/starships")
@ExecuteOn(TaskExecutors.IO)
public class StarshipsController {

    @Inject
    private StarshipsService starshipsService;

    @Get
    public HttpResponse<List<Starship>> getStarshipsUsedByCharacter(@QueryValue String characterName) {
        try {
            List<Starship> starships = starshipsService.getStarshipsUsedByCharacter(characterName);

            if(starships != null) {
                if(starships.size() == 0)
                    return HttpResponse.notFound();
                return HttpResponse.ok(starships);
            }

        } catch (MalformedURLException e) {
            // Pintamos log y devolvemos un HTTP Response de error
            e.printStackTrace();
        }

        return HttpResponse.serverError();
    }

}
