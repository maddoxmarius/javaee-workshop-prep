package com.dedalus.persistence;

import com.dedalus.model.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class UserRepository {
    @Inject
    EntityManager em;

    public UserEntity save(UserEntity entity) {
        em.persist(entity);
        return entity;
    }

    public List<UserEntity> list() {
        return em.createQuery("SELECT a FROM real_user a", UserEntity.class)
                .getResultList();
    }

    public UserEntity findById(Long id) {
        return em.find(UserEntity.class, id);
    }
}
