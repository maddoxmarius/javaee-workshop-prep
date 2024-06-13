package com.dedalus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.dedalus.validation.ValidAnimalType;
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

    @NotEmpty
    @Min(3)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Animal type is required")
    @ValidAnimalType
    private AnimalType type;

    private String comment;
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "adoptedby_id")
    private UserEntity adoptedBy;
}
