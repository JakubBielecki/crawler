package com.crawler.crawler.service;

import com.crawler.crawler.model.Domain;
import com.crawler.crawler.utils.HtmlHelper;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CrawlerServiceImpl implements CrawlerService {

    @Override
    public void analyze(Domain domain) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        DomainAnalyzer domainAnalyzer = new DomainAnalyzer(domain);
        executor.submit(domainAnalyzer);
    }

    public CrawlerServiceImpl() {
    }
}
