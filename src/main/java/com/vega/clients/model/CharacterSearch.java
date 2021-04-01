package com.vega.clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharacterSearch extends Search {

    @JsonProperty("results")
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
