package com.dedalus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "animal")
public class AnimalEntity {
    @Id
    @GeneratedValue
    public Long id;

    private String name;
    private AnimalType type;
    private String comment;
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "adoptedby_id")
    private UserEntity adoptedBy;
}
