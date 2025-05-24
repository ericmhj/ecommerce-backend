package com.mozza.backend.application;

import com.mozza.backend.domain.model.User;
import com.mozza.backend.domain.port.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {


    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save(User user) {

        return iUserRepository.save(user);

    }

    public User findById(Long id) {

        return iUserRepository.findById(id);
    }

    public Iterable<User> findAll(){
        return iUserRepository.findAll();

    }

    
}
