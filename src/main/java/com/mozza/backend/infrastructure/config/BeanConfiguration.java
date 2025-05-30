package com.mozza.backend.infrastructure.config;


import com.mozza.backend.application.CategoryService;
import com.mozza.backend.application.OrderService;
import com.mozza.backend.application.ProductService;
import com.mozza.backend.application.UserService;
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
    public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }

    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);


    }



}
