package com.example.searchengine.search;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public
class SearchDTO {
    private @Id @GeneratedValue Long id;
    private String q;

    public SearchDTO() {}

    public SearchDTO(String q) {
        this.q = q;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getQ() {
        return q;
    }

    @Override
    public String toString() {
        return "SearchDTO{" + "id=" + this.id + ", q='" + this.q + '}';
    }
}
