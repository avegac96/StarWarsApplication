package com.vega.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class URLParser {

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
