package com.vega.services

import com.vega.clients.model.Starship
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class StarshipsServiceSpec extends Specification{

    @Inject
    StarshipsService starshipsService

    void "should return starships used by #character"() {
        when:
        def result = starshipsService.getStarshipsUsedByCharacter(character)

        then:
        result.size() == expected

        where:
        character           | expected
        "Obi-Wan Kenobi"    | 5
        "Luke Skywalker"    | 2
        "Not exists"        | 0
    }
}
