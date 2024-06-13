package com.dedalus.service;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.UserEntity;
import com.dedalus.persistence.AnimalRepository;
import com.dedalus.persistence.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository repository;

    @Override
    public List<UserEntity> list() {
        return repository.list();
    }

    @Override
    public UserEntity save(UserEntity entity) {
         repository.save(entity);
         return entity;
    }

    @Override
    public UserEntity findById(Long id) {
        return repository.findById(id);
    }
}
