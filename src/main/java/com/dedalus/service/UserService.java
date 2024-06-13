package com.dedalus.service;

import java.util.List;
import com.dedalus.model.UserEntity;

public interface UserService {

    List<UserEntity>  list ();

    UserEntity save(UserEntity animalEntity);

    UserEntity findUserById(Long id);
}
