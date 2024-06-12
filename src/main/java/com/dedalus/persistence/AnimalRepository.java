package com.dedalus.persistence;

import java.util.List;
import java.util.UUID;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.dto.AnimalDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class AnimalRepository {
    @Inject
    EntityManager em;

    public AnimalEntity save(AnimalEntity entity) {
        em.persist(entity);
        return entity;
    }

    public List<AnimalEntity> list() {
        return em.createQuery("SELECT a FROM AnimalEntity a", AnimalEntity.class)
                .getResultList();
    }

    public AnimalEntity find(Long id) {

        return em.find(AnimalEntity.class, id);
    }
}
