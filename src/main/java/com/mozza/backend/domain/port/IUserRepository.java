package com.mozza.backend.domain.port;

import com.mozza.backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository  {
    User save(User user);
    User findByEmail(String email);
    User findById(Long id);
    Iterable <User> findAll();



}
