//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernfl
package com.crawler.crawler.view;



import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.net.URL;

@Named
@RequestScoped
public class StartView {
    private URL url;

    public StartView() {
    }

    @PostConstruct
    public void init() {
        this.url = null;
    }

    public String submit() {
        return "result.xhtml?faces-redirect=true&url=" + url.toString();
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
