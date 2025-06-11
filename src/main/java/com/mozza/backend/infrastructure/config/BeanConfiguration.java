package com.mozza.backend.infrastructure.config;


import com.mozza.backend.application.*;
import com.mozza.backend.domain.port.ICategoryRepository;
import com.mozza.backend.domain.port.IOrderRepository;
import com.mozza.backend.domain.port.IProductRepository;
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

    @Bean
    public ProductService productService(IProductRepository iProductRepository, UploadFile uploadFile){
        return new ProductService(iProductRepository,uploadFile);
    }

    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);


    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();

    }




}
