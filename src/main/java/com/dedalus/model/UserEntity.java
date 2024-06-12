package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "real_user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    public Long id;

    private String name;

    @OneToMany(mappedBy = "adoptedBy")
    private Collection<AnimalEntity> animals;
}
