package com.crawler.crawler.model;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Entity
@Table(name = "domain")
public class Domain {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="domain")
    private List<Page> pages;

    @OneToMany(mappedBy="domain")
    private List<Image> images;

    private URL url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
