package com.dedalus.service;

import java.util.List;

import com.dedalus.model.AnimalEntity;

public interface AnimalService {

    List<AnimalEntity>  list ();

    AnimalEntity save(AnimalEntity animalEntity
    );
}
