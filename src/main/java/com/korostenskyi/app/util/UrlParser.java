package com.korostenskyi.app.util;

public final class UrlParser {

    private UrlParser() {
    }

    public static Long getEntityId(String url) {

        if (url.equals("")) {
            return -1L;
        }

        String[] parsedUrl = url.split("/");

        return Long.valueOf(parsedUrl[parsedUrl.length - 1]);
    }
}
