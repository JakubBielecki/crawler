package com.crawler.crawler.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "domain")
public class Domain {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="domain")
    private Set<Page> pages;

    @OneToMany(mappedBy="domain")
    private Set<Image> images;

    private String url;

    public Domain(String url) {
        this.url = url;
        pages = new HashSet<>();
        images = new HashSet<>();
    }

    public Domain() {
        pages = new HashSet<>();
        images = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
