package com.vega.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vega.clients.model.Character;
import com.vega.clients.model.Planet;

import java.util.Map;

public class Mapper {
    private static ObjectMapper mapper = new ObjectMapper();

    public static Planet mapPlanet(Map planet) {
        return mapper.convertValue(planet, Planet.class);
    }

    public static Character mapCharacter(Map character) {
        return mapper.convertValue(character, Character.class);
    }
}
