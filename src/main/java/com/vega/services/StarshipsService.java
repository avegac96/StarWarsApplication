package com.vega.services;

import com.vega.clients.CharactersClient;
import com.vega.clients.StarshipsClient;
import com.vega.clients.model.CharacterSearch;
import com.vega.clients.model.Character;
import com.vega.clients.model.Starship;
import com.vega.utils.URLParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StarshipsService {

    @Inject
    private CharactersClient charactersClient;

    @Inject
    private StarshipsClient starshipsClient;

    public List<Starship> getStarshipsUsedByCharacter(String characterName) throws MalformedURLException {
        List<Starship> starships = new ArrayList<>();

        CharacterSearch characterSearch = charactersClient.getCharacterByName(characterName);

        if(characterSearch != null && characterSearch.getCharacters() != null) {
            Character character = characterSearch.getCharacters().get(0);

            for(String starshipURL : character.getStarships()) {
                String id = URLParser.getIDFromURL(starshipURL);
                Starship starship = starshipsClient.getStarshipByID(id);
                starships.add(starship);
            }
        }

        return starships;
    }

}
