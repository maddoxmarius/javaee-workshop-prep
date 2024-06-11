package com.dedalus.model.dto;

import com.dedalus.model.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnimalDto {
    private String name;
    private AnimalType animalType;
}
