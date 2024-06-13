package com.dedalus.model;

import com.dedalus.validation.ValidAnimalType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "animal")
public class AnimalEntity {
    @Id
    @GeneratedValue
    public Long id;

    @NotEmpty
    @Size(min = 3)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Animal type is required")
    @ValidAnimalType
    private AnimalType type;

    private String comment;
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity adoptedBy;

    @Transient
    private Object typeDetails;
}
