package com.dedalus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AnimalEntity {
    @Id
    @GeneratedValue
    public Long id;

    private String name;
    private AnimalType type;
    private String comment;
    private Boolean isAvailable;
}
