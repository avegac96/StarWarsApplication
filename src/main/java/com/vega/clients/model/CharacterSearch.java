package com.vega.clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterSearch extends Search {

    @JsonProperty("results")
    private List<Character> characters;
}
