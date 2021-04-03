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

    /**
     * Given a character's name, returns starships used by them
     * @param characterName
     * @return
     * @throws MalformedURLException
     */
    public List<Starship> getStarshipsUsedByCharacter(String characterName) throws MalformedURLException {
        List<Starship> starships = new ArrayList<>();

        CharacterSearch characterSearch = charactersClient.getCharacterByName(characterName);

        if(characterSearch != null &&
                characterSearch.getCharacters() != null &&
                characterSearch.getCharacters().size() > 0) {

            Character character = characterSearch.getCharacters().get(0);
            for(String starshipURL : character.getStarships()) {
                String id = URLParser.getIDFromURL(starshipURL);
                Starship starship = starshipsClient.getStarshipByID(id);
                if(starship != null)
                    starships.add(starship);
            }
        }

        return starships;
    }

}
