package com.mozza.backend.application;

import com.mozza.backend.domain.model.Category;
import com.mozza.backend.domain.port.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoryService {
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public Category save (Category category){

       return iCategoryRepository.save(category);

   }

   public Iterable<Category>findAll(){

       return iCategoryRepository.findAll();
   }

    public Category findById(Long id){
        return iCategoryRepository.findById(id);

    }

    public  void deleteById(Long id){

        iCategoryRepository.deleteById(id);

    }

}
