package com.dedalus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name = "real_user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends PanacheEntity {
    private String name;
}

