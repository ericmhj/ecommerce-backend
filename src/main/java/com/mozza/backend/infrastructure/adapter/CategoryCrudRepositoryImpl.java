package com.mozza.backend.infrastructure.adapter;


import com.mozza.backend.domain.model.Category;
import com.mozza.backend.domain.port.ICategoryRepository;
import com.mozza.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {
    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategories(this.iCategoryCrudRepository.findAll());
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.toCategory(this.iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoria con id= "+id+" NO existe")
                )

        );
    }

    @Override
    public void deleteById(Long id) {

        iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoria con id= "+id+" NO existe")
        );

        iCategoryCrudRepository.deleteById(id);
    }
}
