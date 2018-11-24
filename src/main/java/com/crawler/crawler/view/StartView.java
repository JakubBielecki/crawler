//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernfl
package com.crawler.crawler.view;



import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.net.URL;

@Named
public class StartView {
    public URL url;
//    @Autowired
//    private ExpressionsRepository repository;
//    private Expression expression;
//    private List<Expression> tableData;

    public StartView() {
    }


    @PostConstruct
    public void init() {

    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
