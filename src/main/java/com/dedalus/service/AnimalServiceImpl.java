package com.dedalus.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.dto.AnimalDto;
import com.dedalus.persistence.AnimalRepository;

@ApplicationScoped
public class AnimalServiceImpl implements AnimalService {

    @Inject
    AnimalRepository repository;

    @Override
    public List<AnimalEntity> list() {
        return repository.list();
    }

    @Override
    public AnimalEntity save(AnimalEntity entity) {
         repository.save(entity);
         return entity;
    }

    @Override
    public AnimalEntity findById(Long id) {
        return repository.find(id);
    }
}
