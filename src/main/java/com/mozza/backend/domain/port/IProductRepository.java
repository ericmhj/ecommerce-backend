package com.mozza.backend.domain.port;

import com.mozza.backend.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  {
    Product save (Product product);
    Iterable<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
}
