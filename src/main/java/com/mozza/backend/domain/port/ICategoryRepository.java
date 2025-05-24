package com.mozza.backend.domain.port;

import com.mozza.backend.domain.model.Category;



public interface ICategoryRepository {
    Category save (Category category);
    Iterable<Category> findAll();
    Category findById(Long id);
    void deleteById(Long id);
}
