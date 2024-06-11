package com.dedalus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GreetingEntity {
    @Id
    @GeneratedValue
    public Long id;

    private String phrase;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String field) {
        this.phrase = field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
