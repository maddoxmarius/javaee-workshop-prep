package com.dedalus.model.dto;

import com.dedalus.model.AnimalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimalDto {
    private Long id;
    private String name;
    private AnimalType animalType;
    String comment;
    Boolean isAvailable;
}
