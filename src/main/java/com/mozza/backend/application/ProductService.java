package com.mozza.backend.application;

import com.mozza.backend.domain.model.Product;
import com.mozza.backend.domain.port.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductService {


    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public Product save(Product product){

        return iProductRepository.save(product);
    }


    public Product findById(Long id){

        return this.iProductRepository.findById(id);
    }
    public Iterable<Product>findAll(){

        return this.iProductRepository.findAll();

    }


    void deleteById(Long id){

        this.iProductRepository.deleteById(id);
    }


}
