package com.dedalus.service;

import com.dedalus.model.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static com.dedalus.model.UserEntity.*;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Override
    public List<UserEntity> list() {
        return listAll();
    }

    @Override
    public UserEntity save(UserEntity entity) {
        entity.persist();
        return entity;
    }

    @Override
    public UserEntity findUserById(Long id) {
        return findById(id);
    }
}
