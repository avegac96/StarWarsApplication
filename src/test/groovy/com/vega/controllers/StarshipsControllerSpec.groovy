package com.vega.controllers

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class StarshipsControllerSpec extends Specification{

    @Inject
    StarshipsController starshipsController

    void "should return HttpResponse with starships used by #character"() {
        when:
        def result = starshipsController.getStarshipsUsedByCharacter(character)

        then:
        result.getBody().get().size() == expected

        where:
        character           | expected
        "Obi-Wan Kenobi"    | 5
        "Luke Skywalker"    | 2
        "Not exists"        | 0
    }
}
