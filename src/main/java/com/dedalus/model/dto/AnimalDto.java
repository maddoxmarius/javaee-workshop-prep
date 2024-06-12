package com.dedalus.model.dto;

import com.dedalus.model.AnimalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimalDto {
    private String name;
    private AnimalType animalType;
    String comment;
    Boolean isAvailable;
    public AnimalDto(String name, AnimalType animalType)
    {
        this.name = name;
        this.animalType = animalType;
    }

    public AnimalDto(String name, AnimalType animalType, String comment, Boolean isAvailable)
    {
        this.name = name;
        this.animalType = animalType;
        this.comment = comment;
        this.isAvailable = isAvailable;
    }
}
