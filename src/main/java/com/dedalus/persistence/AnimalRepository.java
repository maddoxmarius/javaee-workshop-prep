package com.dedalus.persistence;

import com.dedalus.model.AnimalEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

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
