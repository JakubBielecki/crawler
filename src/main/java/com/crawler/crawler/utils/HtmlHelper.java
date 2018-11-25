package com.crawler.crawler.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class HtmlHelper {

    public static String getHTMLPageFromUrl(URL url) throws IOException {
        return new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
    }
}
