package com.crawler.crawler.service;

import com.crawler.crawler.model.Domain;
import com.crawler.crawler.utils.HtmlHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DomainAnalyzer implements Runnable {

    private Logger logger = LoggerFactory.getLogger(DomainAnalyzer.class);

    private Domain domain;
    private Queue<String> subdomains = new LinkedBlockingQueue<>();

    // Pattern for recognizing a URL, based off RFC 3986
    private static final Pattern urlPattern = Pattern.compile(
            "((ht|f)tp(s?):\\/\\/|www\\.)"
                    + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                    + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};]*)",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static String imagePattern = "https?:/(?:/[^/]+)+\\.(?:jpg|gif|png)";

    @Override
    public void run() {
        logger.info("DomainAnalyzer");
        Set<String> history = new HashSet<>();
        history.add(domain.getUrl());
        subdomains.offer(domain.getUrl());
        while(subdomains.size() > 0) {
            Set<String> urls = analyzeURL(subdomains.poll());
            subdomains.addAll(urls.stream()
                    .filter(u -> u.startsWith(domain.getUrl()))
                    .filter(u -> !history.contains(u))
                    .collect(Collectors.toList()));
            history.addAll(urls);
            logger.info("Subdomains to analyze: " + subdomains.size());
        }
        logReport(history);
    }

    private void logReport(Set<String> history) {
        logger.info("All images:");
        history.stream().filter(u -> u.matches(imagePattern)).sorted().forEach(u -> logger.info(u));
        logger.info("All pages:");
        history.stream().filter(u -> u.contains(domain.getUrl())).sorted().forEach(u -> logger.info(u));
    }


    private Set<String> analyzeURL(String url) {
        Set<String> result = new HashSet<>();
        try {
            logger.info("Analyzing subdomain:  ->  " + url);
            String htmlPage = HtmlHelper.getHTMLPageFromUrl(new URL(url));

            Matcher urlMatcher = urlPattern.matcher(htmlPage);

            while (urlMatcher.find()) {
                result.add(htmlPage.substring(urlMatcher.start(0),
                        urlMatcher.end(0)));
            }
        } catch (IOException e) {
            logger.warn("Can't read: " + url);
        }
        return result;
    }

    DomainAnalyzer(Domain domain) {
        this.domain = domain;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
