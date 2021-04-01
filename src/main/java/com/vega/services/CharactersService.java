package com.vega.services;

import com.vega.clients.CharactersClient;
import com.vega.clients.PlanetsClient;
import com.vega.clients.model.PlanetSearch;
import com.vega.clients.model.Planet;
import com.vega.utils.URLParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.vega.clients.model.Character;

@Singleton
public class CharactersService {

    @Inject
    private PlanetsClient planetsClient;

    @Inject
    private CharactersClient charactersClient;

    public List<String> getCharactersFromPlanet(String planetName) throws MalformedURLException {
        List<String> charactersName = new ArrayList<>();

        PlanetSearch planetSearch = planetsClient.getPlanetByName(planetName);

        if(planetSearch != null && planetSearch.getPlanets() != null) {
            Planet planet = planetSearch.getPlanets().get(0);

            for(String characterURL : planet.getResidents()) {
                String id = URLParser.getIDFromURL(characterURL);
                Character character = charactersClient.getCharacterByID(id);
                charactersName.add(character.getName());
            }
        }

        return charactersName;

    }
}
