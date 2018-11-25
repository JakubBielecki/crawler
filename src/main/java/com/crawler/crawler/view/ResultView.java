package com.crawler.crawler.view;

import com.crawler.crawler.model.Domain;
import com.crawler.crawler.repository.DomainRepository;
import com.crawler.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.net.URL;

@Named
@RequestScoped
public class ResultView {

    private Domain domain;
    private URL url;

    @Autowired
    DomainRepository domainRepository;

    @Autowired
    private CrawlerService crawlerService;

    public void init() {
        domain = domainRepository.findFirstByUrl(url.toString());
    //    if(domain == null) {
            domain = new Domain(url.toString());
            domainRepository.save(domain);
            crawlerService.analyze(domain);
     //   }
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public CrawlerService getCrawlerService() {
        return crawlerService;
    }

    public void setCrawlerService(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }
}
