package com.dedalus.service;

import java.util.List;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.dto.AnimalDto;

public interface AnimalService {

    List<AnimalEntity>  list ();

    AnimalEntity save(AnimalEntity animalEntity
    );

    AnimalEntity findById(Long id);
}
