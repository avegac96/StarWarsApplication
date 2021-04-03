package com.vega.services

import com.vega.services.CharactersService
import com.vega.utils.URLParser
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class CharactersServiceSpec extends Specification{

    @Inject
    CharactersService charactersService

    @Shared
    List<String> nabooCharacters

    @Shared
    List<String> tatooineCharacters

    @Shared
    List<String> voidList

    def setupSpec(){
        nabooCharacters = Arrays.asList("R2-D2","Palpatine","Padmé Amidala","Jar Jar Binks","Roos Tarpals",
                "Rugor Nass","Ric Olié","Quarsh Panaka","Gregar Typho","Cordé","Dormé")

        tatooineCharacters = Arrays.asList("Luke Skywalker","C-3PO","Darth Vader","Owen Lars","Beru Whitesun lars",
                "R5-D4","Biggs Darklighter","Anakin Skywalker","Shmi Skywalker","Cliegg Lars")

        voidList = new ArrayList<>()
    }

    void "should return characters from #planetName"() {
        when:
        def result = charactersService.getCharactersFromPlanet(planetName)

        then:
        result == expected

        where:
        planetName       | expected
        "Naboo"          | nabooCharacters
        "Tatooine"       | tatooineCharacters
        "NotExists"      | voidList
    }
}
