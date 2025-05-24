package com.mozza.backend.infrastructure.adapter;

import com.mozza.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository <UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);

}
