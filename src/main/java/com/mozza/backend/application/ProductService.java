package com.mozza.backend.application;

import com.mozza.backend.domain.model.Product;
import com.mozza.backend.domain.port.IProductRepository;
import org.springframework.transaction.annotation.Transactional;

public class ProductService {


    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Transactional
    public Product save(Product product){

        return iProductRepository.save(product);
    }


    public Product findById(Long id){

        return this.iProductRepository.findById(id);
    }
    public Iterable<Product>findAll(){

        return this.iProductRepository.findAll();

    }


    public void deleteById(Long id){

        this.iProductRepository.deleteById(id);
    }


}
