package com.dedalus.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.dedalus.model.AnimalEntity;
import com.dedalus.persistence.AnimalRepository;
import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class AnimalServiceImpl implements AnimalService {

    @Inject
    AnimalRepository repository;

    @Override
    @CacheResult(cacheName = "all-animals-cache")
    public List<AnimalEntity> list() {
        return repository.list();
    }

    @Override
    public AnimalEntity save(AnimalEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @CacheResult(cacheName = "animal-cache")
    public AnimalEntity findById(Long id) {
        System.out.println("Diees wird nur einmal geprintet., den der cache funlktioniert." + id);
        return repository.find(id);
    }
}
