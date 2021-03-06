package com.crawler.crawler.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="domain_id", nullable=false)
    private Domain domain;

    private String url;

    public Long getId() {
        return id;
    }

    public Image(Domain domain, String url) {
        this.domain = domain;
        this.url = url;
    }

    public Image() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}
