package com.crawler.crawler.view;

import com.crawler.crawler.model.Domain;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.net.URL;

@Named
@RequestScoped
public class ResultView {

    Domain domain;

    URL url;

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
}
