package com.vega.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class URLParser {

    /**
     * Extracts the ID from a Swapi URL
     * Example: 'http://swapi.dev/api/films/6/' will return '6'
     * @param urlString
     * @return
     * @throws MalformedURLException
     */
    public static String getIDFromURL(String urlString) throws MalformedURLException {
        URL url = new URL(urlString);

        String path = url.getPath();
        return getLastPath(path);
    }

    private static String getLastPath(String path) {
        String[] segments = path.split("/");
        return segments[segments.length - 1];
    }
}
