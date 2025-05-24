package com.mozza.backend.infrastructure.config;


import com.mozza.backend.application.CategoryService;
import com.mozza.backend.application.UserService;
import com.mozza.backend.domain.port.ICategoryRepository;
import com.mozza.backend.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);

    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){

        return new CategoryService(iCategoryRepository);
    }



}
