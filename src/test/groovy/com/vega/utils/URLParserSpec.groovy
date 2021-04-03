package com.vega.utils;

import com.vega.utils.URLParser;
import io.micronaut.test.extensions.spock.annotation.MicronautTest;
import spock.lang.Specification;

@MicronautTest
public class URLParserSpec extends Specification {

    void "should return id from #url"() {
        when:
        def result = URLParser.getIDFromURL(url)

        then:
        result == expected

        where:
        url                                 | expected
        "http://swapi.dev/api/films/1/"     | "1"
        "http://swapi.dev/api/films/9/"     | "9"
        "http://swapi.dev/api/people/50/"   | "50"
    }
}
